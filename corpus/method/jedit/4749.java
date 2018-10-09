//}}}
//{{{ definePackage(clazz) method
private void definePackage(String clazz) throws IOException {
    int idx = clazz.lastIndexOf('.');
    if (idx != -1) {
        String name = clazz.substring(0, idx);
        if (getPackage(name) == null)
            definePackage(name, new JarFile(jar.getFile()).getManifest());
    // TODO: getPackage is deprecated as of Java 9, use next line when jEdit requires Java 9
    //if (getDefinedPackage(name) == null) definePackage(name, new JarFile(jar.getFile()).getManifest());
    }
}