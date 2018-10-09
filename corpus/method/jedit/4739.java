//}}}
//{{{ getVFSs() method
/**
	 * Returns a list of all registered filesystems.
	 * @since jEdit 4.2pre1
	 */
public static String[] getVFSs() {
    // the sooner ppl move to the new api, the less we'll need
    // crap like this
    List<String> returnValue = new LinkedList<String>();
    String[] newAPI = ServiceManager.getServiceNames(SERVICE);
    if (newAPI != null)
        Collections.addAll(returnValue, newAPI);
    return returnValue.toArray(new String[returnValue.size()]);
}