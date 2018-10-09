//{{{ loadServices() method
/**
	 * Loads a <code>services.xml</code> file.
	 * @since jEdit 4.2pre1
	 */
public static void loadServices(PluginJAR plugin, URL uri, PluginJAR.PluginCacheEntry cache) {
    ServiceListHandler dh = new ServiceListHandler(plugin, uri);
    try {
        InputStream in;
        try {
            in = uri.openStream();
        } catch (FileNotFoundException e) {
            in = null;
            Log.log(Log.WARNING, ServiceManager.class, "Unable to open: " + uri);
        }
        if (in != null && !XMLUtilities.parseXML(uri.openStream(), dh) && cache != null) {
            cache.cachedServices = dh.getCachedServices();
        }
    } catch (IOException ioe) {
        Log.log(Log.ERROR, ServiceManager.class, ioe);
    }
}