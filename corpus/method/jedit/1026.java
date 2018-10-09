/**
        Get a resource URL using the BeanShell classpath
        @param path should be an absolute path
    */
public URL getResource(String path) {
    URL url = null;
    if (externalClassLoader != null) {
        // classloader wants no leading slash
        url = externalClassLoader.getResource(path.substring(1));
    }
    if (url == null)
        url = Interpreter.class.getResource(path);
    return url;
}