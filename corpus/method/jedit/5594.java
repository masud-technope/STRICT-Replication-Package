//}}}
//{{{ Package-private members
//{{{ Static methods
//{{{ getPluginCache() method
public static PluginCacheEntry getPluginCache(PluginJAR plugin) {
    String jarCachePath = plugin.getCachePath();
    if (jarCachePath == null)
        return null;
    DataInputStream din = null;
    try {
        PluginCacheEntry cache = new PluginCacheEntry();
        cache.plugin = plugin;
        cache.modTime = plugin.getFile().lastModified();
        din = new DataInputStream(new BufferedInputStream(new FileInputStream(jarCachePath)));
        if (cache.read(din))
            return cache;
        else {
            // returns false with outdated cache
            return null;
        }
    } catch (FileNotFoundException fnf) {
        return null;
    } catch (IOException io) {
        Log.log(Log.ERROR, PluginJAR.class, io);
        return null;
    } finally {
        IOUtilities.closeQuietly((Closeable) din);
    }
}