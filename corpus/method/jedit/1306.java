// Classpath mutators
/**
	*/
public void addClassPath(URL path) throws IOException {
    if (baseLoader == null)
        setClassPath(new URL[] { path });
    else {
        // opportunity here for listener in classpath
        baseLoader.addURL(path);
        baseClassPath.add(path);
        classLoaderChanged();
    }
}