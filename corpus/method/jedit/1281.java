/**
		Get the class file entries from the Jar
	*/
static String[] searchJarForClasses(URL jar) throws IOException {
    Vector v = new Vector();
    InputStream in = jar.openStream();
    ZipInputStream zin = new ZipInputStream(in);
    ZipEntry ze;
    while ((ze = zin.getNextEntry()) != null) {
        String name = ze.getName();
        if (isClassFileName(name))
            v.addElement(canonicalizeClassName(name));
    }
    zin.close();
    String[] sa = new String[v.size()];
    v.copyInto(sa);
    return sa;
}