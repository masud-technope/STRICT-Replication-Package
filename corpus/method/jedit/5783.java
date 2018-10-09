String getInstalledVersion() {
    this.loaded = false;
    PluginJAR[] jars = jEdit.getPluginJARs();
    for (int i = 0; i < jars.length; i++) {
        String path = jars[i].getPath();
        if (MiscUtilities.getFileName(path).equals(jar)) {
            EditPlugin plugin = jars[i].getPlugin();
            if (plugin != null) {
                installedVersion = jEdit.getProperty("plugin." + plugin.getClassName() + ".version");
                this.loaded = true;
                return installedVersion;
            } else
                return null;
        }
    }
    String[] notLoadedJars = jEdit.getNotLoadedPluginJARs();
    for (String path : notLoadedJars) {
        if (MiscUtilities.getFileName(path).equals(jar)) {
            try {
                PluginJAR.PluginCacheEntry cacheEntry = PluginJAR.getPluginCacheEntry(path);
                if (cacheEntry != null) {
                    String versionKey = "plugin." + cacheEntry.pluginClass + ".version";
                    installedVersion = cacheEntry.cachedProperties.getProperty(versionKey);
                    Log.log(Log.DEBUG, PluginList.class, "found installed but not loaded " + jar + " version=" + installedVersion);
                    installedPath = path;
                    return installedVersion;
                }
            } catch (IOException e) {
                Log.log(Log.WARNING, "Unable to access cache for " + jar, e);
            }
        }
    }
    return null;
}