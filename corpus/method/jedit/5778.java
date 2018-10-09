// TODO: this isn't used, should it be?
private static String getAutoSelectedMirror() throws java.io.IOException {
    final String samplerUrl = "http://sourceforge.net/projects/jedit/files/latest/download";
    final HttpURLConnection connection = (HttpURLConnection) ((new URL(samplerUrl)).openConnection());
    connection.setInstanceFollowRedirects(false);
    final int response = connection.getResponseCode();
    if (response != HttpURLConnection.HTTP_MOVED_TEMP) {
        throw new RuntimeException("Unexpected response: " + response + ": from " + samplerUrl);
    }
    final String redirected = connection.getHeaderField("Location");
    if (redirected == null) {
        throw new RuntimeException("Missing Location header: " + samplerUrl);
    }
    final String prefix = "use_mirror=";
    final int found = redirected.lastIndexOf(prefix);
    if (found == -1) {
        throw new RuntimeException("Mirror prefix \"use_mirror\" was not found in redirected URL: " + redirected);
    }
    final int start = found + prefix.length();
    final int end = redirected.indexOf('&', start);
    return end != -1 ? redirected.substring(start, end) : redirected.substring(start);
}