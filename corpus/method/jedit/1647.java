/**
        Clear all variables, methods, and imports from this namespace.
        If this namespace is the root, it will be reset to the default
        imports.
        @see #loadDefaultImports()
    */
public void clear() {
    variables = null;
    methods = null;
    importedClasses = null;
    importedPackages = null;
    importedCommands = null;
    importedObjects = null;
    if (parent == null)
        loadDefaultImports();
    classCache = null;
    names = null;
}