/**
		Get a resource URL using the BeanShell classpath
		@param path should be an absolute path
	*/
public URL getResource(String path) {
    URL url = null;
    if (baseLoader != null)
        // classloader wants no leading slash
        url = baseLoader.getResource(path.substring(1));
    if (url == null)
        url = super.getResource(path);
    return url;
}