public static URL[] getUserClassPathComponents() throws ClassPathException {
    if (userClassPathComp != null)
        return userClassPathComp;
    String cp = System.getProperty("java.class.path");
    String[] paths = StringUtil.split(cp, File.pathSeparator);
    URL[] urls = new URL[paths.length];
    try {
        for (int i = 0; i < paths.length; i++) // but JARClassLoader doesn't.
        urls[i] = new File(new File(paths[i]).getCanonicalPath()).toURI().toURL();
    } catch (IOException e) {
        throw new ClassPathException("can't parse class path: " + e);
    }
    userClassPathComp = urls;
    return urls;
}