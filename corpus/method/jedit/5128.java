//}}}
//{{{ openInDesktop() method
/** Opens a file or URI using the desktop file associations.
		<p>
		Uses native desktop commands for each platform, which ask the user to choose an
		association for files that do not already have one, using the desktop's
		dialog, in contrast to Desktop.open() which just throws an IOException
		for unknown types.

		If a URI is supplied, use desktop browser.

		@param path or URI of thing to open/browse
		@author Alan Ezust
		@since jEdit 5.0
	*/
public static void openInDesktop(String path) {
    StringList sl = new StringList();
    if (OperatingSystem.isWindows()) {
        if (MiscUtilities.isURL(path))
            try {
                URI uri = new URI(path);
                java.awt.Desktop.getDesktop().browse(uri);
                return;
            } catch (IOException ioe) {
                Log.log(Log.ERROR, path, "Can't open URI", ioe);
            } catch (URISyntaxException use) {
                Log.log(Log.ERROR, path, "Bad URI syntax:", use);
            }
        else {
            sl.add("rundll32");
            sl.add("SHELL32.DLL,ShellExec_RunDLL");
        }
    } else if (OperatingSystem.isMacOS())
        sl.add("open");
    else if (OperatingSystem.isX11()) {
        /* For gnome, use gnome-open. Need a way of testing that gnome is actually
			   running though. Otherwise it is not the correct program to use.
			File f = new File("/usr/bin/gnome-open");
			if (f.exists()) sl.add("gnome-open");
			else */
        sl.add("xdg-open");
    }
    try {
        if (// I don't know what platform it is
        sl.isEmpty())
            java.awt.Desktop.getDesktop().open(new File(path));
        else {
            sl.add(path);
            Log.log(Log.DEBUG, MiscUtilities.class, "openInDesktop: " + sl.join(" "));
            Runtime.getRuntime().exec(sl.toArray());
        }
    } catch (IOException ioe) {
        Log.log(Log.ERROR, MiscUtilities.class, "openInDesktop failed: " + path, ioe);
    }
}