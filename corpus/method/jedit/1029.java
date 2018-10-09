/**
        Get a resource stream using the BeanShell classpath
        @param path should be an absolute path
    */
public InputStream getResourceAsStream(String path) {
    InputStream in = null;
    if (externalClassLoader != null) {
        // classloader wants no leading slash
        in = externalClassLoader.getResourceAsStream(path.substring(1));
    }
    if (in == null)
        in = Interpreter.class.getResourceAsStream(path);
    return in;
}