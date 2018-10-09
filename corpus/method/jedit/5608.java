// }}}
//{{{ containsClass() function
/**
	 * @param className a class name
	 * @return true if this jar contains a class with that classname.
	 * @since jedit 4.3pre7
	 */
boolean containsClass(String className) {
    try {
        getZipFile();
    } catch (IOException ioe) {
        throw new RuntimeException(ioe);
    }
    Enumeration<? extends ZipEntry> itr = zipFile.entries();
    while (itr.hasMoreElements()) {
        String entry = itr.nextElement().toString();
        if (entry.endsWith(".class")) {
            String name = entry.substring(0, entry.length() - 6).replace('/', '.');
            if (name.equals(className))
                return true;
        }
    }
    return false;
}