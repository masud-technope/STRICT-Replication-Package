/**
        Load the specified class by name, taking into account added classpath
        and reloaded classes, etc.
        Note: Again, this is just a trivial implementation.
        See bsh.classpath.ClassManagerImpl for the fully functional class
        management package.
        @return the class or null
    */
public Class classForName(String name) {
    if (isClassBeingDefined(name))
        throw new InterpreterError("Attempting to load class in the process of being defined: " + name);
    Class clas = null;
    try {
        clas = plainClassForName(name);
    } catch (ClassNotFoundException e) {
    }
    // try scripted class
    if (clas == null)
        clas = loadSourceClass(name);
    return clas;
}