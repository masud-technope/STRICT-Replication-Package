/**
		Get a resource stream using the BeanShell classpath
		@param path should be an absolute path
	*/
public InputStream getResourceAsStream(String path) {
    InputStream in = null;
    if (baseLoader != null) {
        // classloader wants no leading slash
        in = baseLoader.getResourceAsStream(path.substring(1));
    }
    if (in == null) {
        in = super.getResourceAsStream(path);
    }
    return in;
}