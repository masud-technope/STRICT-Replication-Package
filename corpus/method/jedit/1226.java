/**
        This modification allows us to reload classes which are in the
        Java VM user classpath.  We search first rather than delegate to
        the parent classloader (or bootstrap path) first.

        An exception is for BeanShell core classes which are always loaded from
        the same classloader as the interpreter.
    */
public Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
    Class c = null;
    /*
            Check first for classes loaded through this loader.
            The VM will not allow a class to be loaded twice.
        */
    c = findLoadedClass(name);
    if (c != null)
        return c;
    // We should refactor this somehow if it sticks around
    if (name.startsWith(ClassManagerImpl.BSH_PACKAGE))
        try {
            return org.gjt.sp.jedit.bsh.Interpreter.class.getClassLoader().loadClass(name);
        } catch (ClassNotFoundException e) {
        }
    /*
            Try to find the class using our classloading mechanism.
            Note: I wish we didn't have to catch the exception here... slow
        */
    try {
        c = findClass(name);
    } catch (ClassNotFoundException e) {
    }
    if (c == null)
        throw new ClassNotFoundException("here in loaClass");
    if (resolve)
        resolveClass(c);
    return c;
}