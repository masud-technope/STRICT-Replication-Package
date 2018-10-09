/**
		 * Constructor used for jars that aren't loaded.
		 *
		 * @param jar jar file name
		 */
 Entry(String jar) {
    jars = new LinkedList<String>();
    this.jar = jar;
    jars.add(this.jar);
    if (jEdit.getBooleanProperty("plugin." + MiscUtilities.getFileName(jar) + ".disabled"))
        status = DISABLED;
    else
        status = NOT_LOADED;
    PluginJAR.PluginCacheEntry cacheEntry;
    try {
        cacheEntry = PluginJAR.getPluginCacheEntry(jar);
        if (cacheEntry != null) {
            clazz = cacheEntry.pluginClass;
            Properties props = cacheEntry.cachedProperties;
            name = props.getProperty("plugin." + clazz + ".name");
            version = props.getProperty("plugin." + clazz + ".version");
            author = props.getProperty("plugin." + clazz + ".author");
            docs = props.getProperty("plugin." + clazz + ".docs");
            description = props.getProperty("plugin." + clazz + ".description");
        }
    } catch (IOException e) {
        Log.log(Log.WARNING, "Unable to load cache for " + jar, e);
    }
}