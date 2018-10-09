public URLConnection openConnection(URL url) throws IOException {
    PluginResURLConnection c = new PluginResURLConnection(url);
    return c;
}