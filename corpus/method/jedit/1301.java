/**
		@return the class or null
	*/
public Class classForName(String name) {
    // check positive cache
    Class c = (Class) absoluteClassCache.get(name);
    if (c != null)
        return c;
    // check negative cache
    if (absoluteNonClasses.get(name) != null) {
        if (Interpreter.DEBUG)
            Interpreter.debug("absoluteNonClass list hit: " + name);
        return null;
    }
    if (Interpreter.DEBUG)
        Interpreter.debug("Trying to load class: " + name);
    // Check explicitly mapped (reloaded) class...
    ClassLoader overlayLoader = getLoaderForClass(name);
    if (overlayLoader != null) {
        try {
            c = overlayLoader.loadClass(name);
        } catch (Exception e) {
        } catch (NoClassDefFoundError e2) {
            throw noClassDefFound(name, e2);
        }
    // Should be there since it was explicitly mapped
    // throw an error?
    }
    // insure that core classes are loaded from the same loader
    if (c == null) {
        if (name.startsWith(BSH_PACKAGE))
            try {
                c = Interpreter.class.getClassLoader().loadClass(name);
            } catch (ClassNotFoundException e) {
            }
    }
    // Check classpath extension / reloaded classes
    if (c == null) {
        if (baseLoader != null)
            try {
                c = baseLoader.loadClass(name);
            } catch (ClassNotFoundException e) {
            }
    }
    // Optionally try external classloader
    if (c == null) {
        if (externalClassLoader != null)
            try {
                c = externalClassLoader.loadClass(name);
            } catch (ClassNotFoundException e) {
            }
    }
    // or do we need a way to turn this off completely?
    if (c == null) {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null)
                c = Class.forName(name, true, contextClassLoader);
        } catch (ClassNotFoundException // fall through
        e) {
        }// fall through
         catch (SecurityException e) {
        }
    }
    // try plain class forName()
    if (c == null)
        try {
            c = plainClassForName(name);
        } catch (ClassNotFoundException e) {
        }
    // Try scripted class
    if (c == null)
        c = loadSourceClass(name);
    // Cache result (or null for not found)
    // Note: plainClassForName already caches, so it will be redundant
    // in that case, however this process only happens once
    cacheClassInfo(name, c);
    return c;
}