void readPluginList(boolean allowRetry) {
    String mirror = buildMirror(id);
    if (mirror == null)
        return;
    gzipURL = jEdit.getProperty("plugin-manager.export-url");
    gzipURL += "?mirror=" + mirror;
    gzipURL += "&new_url_scheme";
    String path = null;
    if (jEdit.getSettingsDirectory() == null) {
        cachedURL = gzipURL;
    } else {
        path = jEdit.getSettingsDirectory() + File.separator + "pluginMgr-Cached.xml.gz";
        cachedURL = "file:///" + path;
    }
    boolean downloadIt = !id.equals(jEdit.getProperty("plugin-manager.mirror.cached-id"));
    if (path != null) {
        try {
            File f = new File(path);
            if (!f.canRead())
                downloadIt = true;
            long currentTime = System.currentTimeMillis();
            long age = currentTime - f.lastModified();
            /* By default only download plugin lists every 5 minutes */
            long interval = jEdit.getIntegerProperty("plugin-manager.list-cache.minutes", 5) * MILLISECONDS_PER_MINUTE;
            if (age > interval) {
                Log.log(Log.MESSAGE, this, "PluginList cached copy too old. Downloading from mirror. ");
                downloadIt = true;
            }
        } catch (Exception e) {
            Log.log(Log.MESSAGE, this, "No cached copy. Downloading from mirror. ");
            downloadIt = true;
        }
    }
    if (downloadIt && cachedURL != gzipURL) {
        downloadPluginList();
    }
    InputStream in = null, inputStream = null;
    try {
        if (cachedURL != gzipURL)
            Log.log(Log.MESSAGE, this, "Using cached pluginlist");
        inputStream = new URL(cachedURL).openStream();
        XMLReader parser = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        PluginListHandler handler = new PluginListHandler(this, cachedURL);
        in = new BufferedInputStream(inputStream);
        if (in.markSupported()) {
            in.mark(2);
            int b1 = in.read();
            int b2 = in.read();
            in.reset();
            if (b1 == GZIP_MAGIC_1 && b2 == GZIP_MAGIC_2)
                in = new GZIPInputStream(in);
        }
        InputSource isrc = new InputSource(new InputStreamReader(in, "UTF8"));
        isrc.setSystemId("jedit.jar");
        parser.setContentHandler(handler);
        parser.setDTDHandler(handler);
        parser.setEntityResolver(handler);
        parser.setErrorHandler(handler);
        parser.parse(isrc);
    } catch (Exception e) {
        Log.log(Log.ERROR, this, "readpluginlist: error", e);
        if (cachedURL.startsWith("file:///")) {
            Log.log(Log.DEBUG, this, "Unable to read plugin list, deleting cached file and try again");
            new File(cachedURL.substring(8)).delete();
            if (allowRetry) {
                plugins.clear();
                pluginHash.clear();
                pluginSets.clear();
                readPluginList(false);
            }
        }
    } finally {
        IOUtilities.closeQuietly((Closeable) in);
        IOUtilities.closeQuietly((Closeable) inputStream);
    }
}