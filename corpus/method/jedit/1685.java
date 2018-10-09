/**
        Try to make the name into an imported class.
        This method takes into account only imports (class or package)
        found directly in this NameSpace (no parent chain).
    */
private Class getImportedClassImpl(String name) throws UtilEvalError {
    // Try explicitly imported class, e.g. import foo.Bar;
    String fullname = null;
    if (importedClasses != null)
        fullname = (String) importedClasses.get(name);
    if (fullname != null) {
        /*
                Found the full name in imported classes.
            */
        // Try to make the full imported name
        Class clas = classForName(fullname);
        // Handle imported inner class case
        if (clas == null) {
            if (Name.isCompound(fullname))
                try {
                    clas = getNameResolver(fullname).toClass();
                } catch (ClassNotFoundException e) {
                }
            else if (Interpreter.DEBUG)
                Interpreter.debug("imported unpackaged name not found:" + fullname);
            // If found cache the full name in the BshClassManager
            if (clas != null) {
                // (should we cache info in not a class case too?)
                getClassManager().cacheClassInfo(fullname, clas);
                return clas;
            }
        } else
            return clas;
        // should we throw an error here??
        return null;
    }
    /*
            Try imported packages, e.g. "import foo.bar.*;"
            in reverse order of import...
            (give later imports precedence...)
        */
    if (importedPackages != null)
        for (int i = importedPackages.size() - 1; i >= 0; i--) {
            String s = ((String) importedPackages.elementAt(i)) + "." + name;
            Class c = classForName(s);
            if (c != null)
                return c;
        }
    BshClassManager bcm = getClassManager();
    /*
            Try super import if available
            Note: we do this last to allow explicitly imported classes
            and packages to take priority.  This method will also throw an
            error indicating ambiguity if it exists...
        */
    if (bcm.hasSuperImport()) {
        String s = bcm.getClassNameByUnqName(name);
        if (s != null)
            return classForName(s);
    }
    return null;
}