/** Caches it locally */
void downloadPluginList() {
    BufferedInputStream is = null;
    BufferedOutputStream out = null;
    /* download the plugin list, while trying to show informative error messages.
		 * Currently when :
		 * - the proxy requires authentication
		 * - another HTTP error happens (may be good to know that the site is broken)
		 * - the host can't be reached (reported as internet access error)
		 * Otherwise, only an error message is logged in the activity log.
		 **/
    try {
        task.setStatus(jEdit.getProperty("plugin-manager.list-download"));
        URL downloadURL = new URL(gzipURL);
        HttpURLConnection c = (HttpURLConnection) downloadURL.openConnection();
        if (c.getResponseCode() == HttpURLConnection.HTTP_PROXY_AUTH) {
            GUIUtilities.error(jEdit.getActiveView(), "plugin-manager.list-download.need-password", new Object[] {});
            Log.log(Log.ERROR, this, "CacheRemotePluginList: proxy requires authentication");
        } else if (c.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = c.getInputStream();
            String fileName = cachedURL.replaceFirst("file:///", "");
            out = new BufferedOutputStream(new FileOutputStream(fileName));
            long start = System.currentTimeMillis();
            is = new BufferedInputStream(inputStream);
            IOUtilities.copyStream(4096, null, is, out, false);
            jEdit.setProperty("plugin-manager.mirror.cached-id", id);
            Log.log(Log.MESSAGE, this, "Updated cached pluginlist " + (System.currentTimeMillis() - start));
        } else {
            GUIUtilities.error(jEdit.getActiveView(), "plugin-manager.list-download.generic-error", new Object[] { c.getResponseCode(), c.getResponseMessage() });
            Log.log(Log.ERROR, this, "CacheRemotePluginList: HTTP error: " + c.getResponseCode() + c.getResponseMessage());
        }
    } catch (java.net.UnknownHostException e) {
        GUIUtilities.error(jEdit.getActiveView(), "plugin-manager.list-download.disconnected", new Object[] { e.getMessage() });
        Log.log(Log.ERROR, this, "CacheRemotePluginList: error", e);
    } catch (Exception e) {
        Log.log(Log.ERROR, this, "CacheRemotePluginList: error", e);
    } finally {
        IOUtilities.closeQuietly((Closeable) out);
        IOUtilities.closeQuietly((Closeable) is);
    }
}