/**
        Find the correct source for the class...

        Try designated loader if any
        Try our URLClassLoader paths if any
        Try base loader if any
        Try system ???
    */
// add some caching for not found classes?
protected Class findClass(String name) throws ClassNotFoundException {
    // Deal with this cast somehow... maybe have this class use
    // ClassManagerImpl type directly.
    // Don't add the method to BshClassManager... it's really an impl thing
    ClassManagerImpl bcm = (ClassManagerImpl) getClassManager();
    // Should we try to load the class ourselves or delegate?
    // look for overlay loader
    // Deal with this cast somehow... maybe have this class use
    // ClassManagerImpl type directly.
    // Don't add the method to BshClassManager... it's really an impl thing
    ClassLoader cl = bcm.getLoaderForClass(name);
    Class c;
    // If there is a designated loader and it's not us delegate to it
    if (cl != null && cl != this)
        try {
            return cl.loadClass(name);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Designated loader could not find class: " + e);
        }
    // Let URLClassLoader try any paths it may have
    if (getURLs().length > 0)
        try {
            return super.findClass(name);
        } catch (ClassNotFoundException e) {
        }
    // If there is a baseLoader and it's not us delegate to it
    cl = bcm.getBaseLoader();
    if (cl != null && cl != this)
        try {
            return cl.loadClass(name);
        } catch (ClassNotFoundException e) {
        }
    // Try system loader
    return bcm.plainClassForName(name);
}