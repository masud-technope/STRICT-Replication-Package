//}}}
//}}} Property methods fold end
//{{{ Plugin management methods
//{{{ getNotLoadedPluginJARs() method
/**
	 * Returns a list of plugin JARs pathnames that are not currently loaded
	 * by examining the user and system plugin directories.
	 * @since jEdit 3.2pre1
	 */
public static String[] getNotLoadedPluginJARs() {
    List<String> returnValue = new ArrayList<String>();
    if (jEditHome != null) {
        String systemPluginDir = MiscUtilities.constructPath(jEditHome, "jars");
        String[] list = new File(systemPluginDir).list();
        if (list != null)
            getNotLoadedPluginJARs(returnValue, systemPluginDir, list);
    }
    if (settingsDirectory != null) {
        String userPluginDir = MiscUtilities.constructPath(settingsDirectory, "jars");
        String[] list = new File(userPluginDir).list();
        if (list != null) {
            getNotLoadedPluginJARs(returnValue, userPluginDir, list);
        }
    }
    String[] _returnValue = new String[returnValue.size()];
    returnValue.toArray(_returnValue);
    return _returnValue;
}