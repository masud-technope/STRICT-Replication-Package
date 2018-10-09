//}}}
//{{{ getDeclaredJars() method
/**
	 * Returns a collection of declared jars in the plugin.
	 * If the plugin is loaded use {@link org.gjt.sp.jedit.PluginJAR#getRequiredJars()}
	 * instead
	 *
	 * @param jarPath the path to the jar of the plugin
	 * @return a collection containing jars path
	 * @throws IOException if jEdit cannot generate cache
	 * @since jEdit 4.3pre12
	 */
private static Collection<String> getDeclaredJars(String jarPath) throws IOException {
    Collection<String> jarList = new ArrayList<String>();
    PluginJAR pluginJAR = new PluginJAR(new File(jarPath));
    PluginJAR.PluginCacheEntry pluginCacheEntry = PluginJAR.getPluginCacheEntry(jarPath);
    if (pluginCacheEntry != null) {
        Properties cachedProperties = pluginCacheEntry.cachedProperties;
        String jars = cachedProperties.getProperty("plugin." + pluginCacheEntry.pluginClass + ".jars");
        if (jars != null) {
            Collection<String> jarsPaths = PluginJAR.parseJarsFilesString(pluginJAR.getPath(), jars);
            for (String _jarPath : jarsPaths) {
                if (new File(_jarPath).exists())
                    jarList.add(_jarPath);
            }
        }
    }
    jarList.add(jarPath);
    return jarList;
}