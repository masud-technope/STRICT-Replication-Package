//}}}
//{{{ initPlugins() method
/**
	 * Loads plugins.
	 */
private static void initPlugins() {
    if (jEditHome != null) {
        addPluginJARsFromDirectory(MiscUtilities.constructPath(jEditHome, "jars"));
    }
    if (settingsDirectory != null) {
        File jarsDirectory = new File(settingsDirectory, "jars");
        if (!jarsDirectory.exists())
            jarsDirectory.mkdir();
        addPluginJARsFromDirectory(jarsDirectory.getPath());
    }
    PluginJAR[] jars = getPluginJARs();
    for (PluginJAR jar : jars) jar.checkDependencies();
}