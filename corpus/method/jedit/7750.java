/** Searches available FileOpenerServices and uses the first, or the
	*   preferred one based on the "fileopener.service" property.
	*
	*   You can set a preferred FileOpener from the Console beanshell like this:
	*   <pre>
	*   jEdit.setProperty("fileopener.service", "FastOpen");  // or "SmartOpen"
	*   </pre>
	*   This setting is ignored if there is only one FileOpenerService available.
	*
	*   @param fileName the file name to search for
	*   @param view the parent View
        */
public static void open(String fileName, View view) {
    String[] finders = ServiceManager.getServiceNames(FileOpenerService.class);
    // No installed finders, do nothing
    if (finders.length == 0)
        return;
    String myFinder = finders[0];
    // See if user set a preferred service
    if (finders.length > 1)
        myFinder = jEdit.getProperty("fileopener.service", myFinder);
    // try to get the service
    Object obj = ServiceManager.getService(FileOpenerService.class, myFinder);
    // Preferred service is not found, use the only one available instead
    if ((obj == null) && (!myFinder.equals(finders[0])))
        obj = ServiceManager.getService(FileOpenerService.class, finders[0]);
    // Open the file!
    ((FileOpenerService) obj).openFile(fileName, view);
}