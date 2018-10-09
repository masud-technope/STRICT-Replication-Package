//}}}
//{{{ indexURL() method
/**
	 * Reads the specified HTML file and adds all words defined therein to the
	 * index.
	 * @param path The HTML file's URL or path
	 */
public void indexURL(String path) throws Exception {
    URL url;
    if (MiscUtilities.isURL(path))
        url = new URL(path);
    else {
        File f = new File(path);
        url = f.toURI().toURL();
    }
    InputStream _in;
    _in = url.openStream();
    indexStream(_in, url.toString());
}