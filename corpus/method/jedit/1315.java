// class reloading
/**
		Reloading classes means creating a new classloader and using it
		whenever we are asked for classes in the appropriate space.
		For this we use a DiscreteFilesClassLoader
	*/
public void reloadClasses(String[] classNames) throws ClassPathException {
    // init base class loader if there is none...
    if (baseLoader == null)
        initBaseLoader();
    DiscreteFilesClassLoader.ClassSourceMap map = new DiscreteFilesClassLoader.ClassSourceMap();
    for (int i = 0; i < classNames.length; i++) {
        String name = classNames[i];
        // look in baseLoader class path 
        ClassSource classSource = baseClassPath.getClassSource(name);
        // look in user class path 
        if (classSource == null) {
            BshClassPath.getUserClassPath().insureInitialized();
            classSource = BshClassPath.getUserClassPath().getClassSource(name);
        }
        if (classSource == null)
            throw new ClassPathException("Nothing known about class: " + name);
        // to handle it... since it is a URLClassLoader and can handle JARs
        if (classSource instanceof JarClassSource)
            throw new ClassPathException("Cannot reload class: " + name + " from source: " + classSource);
        map.put(name, classSource);
    }
    // Create classloader for the set of classes
    ClassLoader cl = new DiscreteFilesClassLoader(this, map);
    // map those classes the loader in the overlay map
    Iterator it = map.keySet().iterator();
    while (it.hasNext()) loaderMap.put((String) it.next(), cl);
    classLoaderChanged();
}