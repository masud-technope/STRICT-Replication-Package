/**
        Implementation of getClass()

        Load a class through this namespace taking into account imports.
        <p>

        Check the cache first.  If an unqualified name look for imported
        class or package.  Else try to load absolute name.
        <p>

        This method implements caching of unqualified names (normally imports).
        Qualified names are cached by the BshClassManager.
        Unqualified absolute class names (e.g. unpackaged Foo) are cached too
        so that we don't go searching through the imports for them each time.

        @return null if not found.
    */
private Class getClassImpl(String name) throws UtilEvalError {
    Class c = null;
    // Check the cache
    if (classCache != null) {
        c = (Class) classCache.get(name);
        if (c != null)
            return c;
    }
    // Unqualified (simple, non-compound) name
    boolean unqualifiedName = !Name.isCompound(name);
    // Unqualified name check imported
    if (unqualifiedName) {
        // Try imported class
        if (c == null)
            c = getImportedClassImpl(name);
        // if found as imported also cache it
        if (c != null) {
            cacheClass(name, c);
            return c;
        }
    }
    // Try absolute
    c = classForName(name);
    if (c != null) {
        // Cache unqualified names to prevent import check again
        if (unqualifiedName)
            cacheClass(name, c);
        return c;
    }
    // Not found
    if (Interpreter.DEBUG)
        Interpreter.debug("getClass(): " + name + " not	found in " + this);
    return null;
}