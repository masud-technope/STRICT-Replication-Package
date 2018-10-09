//{{{ download() method
private String download(PluginManagerProgress progress, String url) {
    try {
        String host = jEdit.getProperty("plugin-manager.mirror.id");
        if (host == null || host.equals(MirrorList.Mirror.NONE))
            host = "default";
        // follow HTTP redirects
        boolean finalUrlFound = false;
        String finalUrl = url;
        URLConnection conn = null;
        while (!finalUrlFound) {
            Log.log(Log.DEBUG, this, String.format("Trying URL '%s'", finalUrl));
            conn = new URL(finalUrl).openConnection();
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setInstanceFollowRedirects(false);
            httpConn.connect();
            int responseCode = httpConn.getResponseCode();
            String locationHeader = httpConn.getHeaderField("Location");
            if ((responseCode >= 300) && (responseCode < 400) && (locationHeader != null))
                finalUrl = locationHeader.replaceFirst("^https:", "http:");
            else
                finalUrlFound = true;
        }
        Log.log(Log.DEBUG, this, String.format("Final URL '%s' found", finalUrl));
        String fileName = MiscUtilities.getFileName(finalUrl);
        String path = MiscUtilities.constructPath(getDownloadDir(), fileName);
        Matcher hostMatcher = HOST_REGEX.matcher(finalUrl);
        if (hostMatcher.find())
            host = hostMatcher.group();
        String progressMessage = jEdit.getProperty("plugin-manager.progress", new String[] { fileName, host });
        progress.setStatus(progressMessage);
        try (InputStream in = conn.getInputStream();
            FileOutputStream out = new FileOutputStream(path)) {
            if (!IOUtilities.copyStream(progress, progressMessage, in, out, true))
                return null;
        }
        return path;
    } catch (InterruptedIOException iio) {
        return null;
    } catch (FileNotFoundException e) {
        Log.log(Log.ERROR, this, e);
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                GUIUtilities.error(null, "plugin-error-download", new Object[] { "" });
            }
        });
        return null;
    } catch (final IOException io) {
        Log.log(Log.ERROR, this, io);
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                String[] args = { io.getMessage() };
                GUIUtilities.error(null, "plugin-error-download", args);
            }
        });
        return null;
    } catch (Exception e) {
        Log.log(Log.ERROR, this, e);
        return null;
    }
//}}}
}