//}}}
//{{{ addPluginJARsFromDirectory() method
/**
	 * Loads all plugins in a directory.
	 * @param directory The directory
	 * @since jEdit 4.2pre1
	 */
private static void addPluginJARsFromDirectory(String directory) {
    Log.log(Log.NOTICE, jEdit.class, "Loading plugins from " + directory);
    File file = new File(directory);
    if (!(file.exists() && file.isDirectory()))
        return;
    String[] plugins = file.list();
    if (plugins == null)
        return;
    for (String plugin : plugins) {
        if (!plugin.toLowerCase().endsWith(".jar"))
            continue;
        String path = MiscUtilities.constructPath(directory, plugin);
        if (jEdit.getBooleanProperty("plugin-blacklist." + plugin))
            continue;
        addPluginJAR(path);
    }
}