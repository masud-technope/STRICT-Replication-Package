//}}}
//{{{ indexJAR() method
/**
	 * Indexes all HTML and text files in the specified JAR file.
	 * @param jar The JAR file
	 */
public void indexJAR(ZipFile jar) throws Exception {
    Enumeration e = jar.entries();
    while (e.hasMoreElements()) {
        ZipEntry entry = (ZipEntry) e.nextElement();
        String name = entry.getName();
        String lname = name.toLowerCase();
        if (lname.endsWith(".html") || lname.endsWith(".txt")) {
            // only works for jEdit plugins
            String url = "jeditresource:/" + MiscUtilities.getFileName(jar.getName()) + "!/" + name;
            Log.log(Log.DEBUG, this, url);
            indexStream(jar.getInputStream(entry), url);
        }
    }
}