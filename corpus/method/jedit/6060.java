//{{{ constructor
public  PluginResURLConnection(URL url) throws IOException {
    super(url);
    String file = url.getFile();
    int index = file.indexOf('!', 0);
    if (index == -1) {
        plugin = null;
        resource = file;
    } else {
        int start;
        if (file.charAt(0) == '/')
            start = 1;
        else
            start = 0;
        plugin = file.substring(start, index);
        resource = file.substring(index + 1);
    }
    if (plugin != null && resource.startsWith("/"))
        resource = resource.substring(1);
}