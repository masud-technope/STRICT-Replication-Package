//}}}
//{{{ setPluginCache() method
static void setPluginCache(PluginJAR plugin, PluginCacheEntry cache) {
    String jarCachePath = plugin.getCachePath();
    if (jarCachePath == null)
        return;
    Log.log(Log.DEBUG, PluginJAR.class, "Writing " + jarCachePath);
    DataOutputStream dout = null;
    try {
        dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(jarCachePath)));
        cache.write(dout);
        dout.close();
    } catch (IOException io) {
        Log.log(Log.ERROR, PluginJAR.class, io);
        IOUtilities.closeQuietly((Closeable) dout);
        new File(jarCachePath).delete();
    }
}