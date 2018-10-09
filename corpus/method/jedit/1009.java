/**
        Flag the class name as being in the process of being defined.
        The class manager will not attempt to load it.
    */
/*
        Note: this implementation is temporary. We currently keep a flat
        namespace of the base name of classes.  i.e. BeanShell cannot be in the
        process of defining two classes in different packages with the same
        base name.  To remove this limitation requires that we work through
        namespace imports in an analogous (or using the same path) as regular
        class import resolution.  This workaround should handle most cases
        so we'll try it for now.
    */
protected void definingClass(String className) {
    String baseName = Name.suffix(className, 1);
    int i = baseName.indexOf('$');
    if (i != -1)
        baseName = baseName.substring(i + 1);
    String cur = (String) definingClassesBaseNames.get(baseName);
    if (cur != null)
        throw new InterpreterError("Defining class problem: " + className + ": BeanShell cannot yet simultaneously define two or more " + "dependant classes of the same name.  Attempt to define: " + className + " while defining: " + cur);
    definingClasses.put(className, NOVALUE);
    definingClassesBaseNames.put(baseName, className);
}