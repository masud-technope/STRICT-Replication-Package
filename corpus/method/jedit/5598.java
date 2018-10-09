//}}}
//{{{ init() method
public boolean init() {
    PluginCacheEntry cache = getPluginCache(this);
    if (cache != null) {
        if (!loadCache(cache))
            return false;
        classLoader.activate();
    } else {
        try {
            cache = generateCache();
            if (cache != null) {
                setPluginCache(this, cache);
                classLoader.activate();
            } else {
                return false;
            }
        } catch (IOException io) {
            Log.log(Log.ERROR, this, "Cannot load" + " plugin " + path);
            Log.log(Log.ERROR, this, io);
            String[] args = { io.toString() };
            jEdit.pluginError(path, "plugin-error.load-error", args);
            uninit(false);
        }
    }
    return true;
}