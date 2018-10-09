//}}}
//{{{ getPluginCacheEntry() method
/**
	 * Returns the cache entry for an installed but not loaded plugin.
	 * There is no need to use this method if the plugin is loaded.
	 *
	 * @param path path to the the plugin jar
	 * @return cache entry or null
	 * @throws IOException if jEdit cannot generate cache
	 * @since jEdit 5.3pre1
	 */
public static PluginJAR.PluginCacheEntry getPluginCacheEntry(String path) throws IOException {
    PluginJAR pluginJAR = new PluginJAR(new File(path));
    PluginJAR.PluginCacheEntry pluginCacheEntry = PluginJAR.getPluginCache(pluginJAR);
    if (pluginCacheEntry == null) {
        try {
            pluginCacheEntry = pluginJAR.generateCache();
        } finally {
            IOUtilities.closeQuietly(pluginJAR.getZipFile());
        }
    }
    if (pluginCacheEntry == null) {
        // this happens when, for some reason, two versions
        // of a plugin are installed, e.g when XSLT.jar and
        // xslt.jar are both in $JEDIT_HOME/jars on Linux.
        Log.log(Log.WARNING, PluginJAR.class, "couldn't load plugin " + pluginJAR.getPath() + " (most likely other version exists)");
    }
    return pluginCacheEntry;
}