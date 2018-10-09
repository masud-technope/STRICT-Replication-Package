/**
        Create a new instance of the class manager.
        Class manager instnaces are now associated with the interpreter.

        @see org.gjt.sp.jedit.bsh.Interpreter#getClassManager() getClassManager
        @see org.gjt.sp.jedit.bsh.Interpreter#setClassLoader(ClassLoader) setClassLoader
    */
public static BshClassManager createClassManager(Interpreter interpreter) {
    BshClassManager manager;
    // Do we have the necessary jdk1.2 packages and optional package?
    if (Capabilities.classExists("java.lang.ref.WeakReference") && Capabilities.classExists("java.util.HashMap") && Capabilities.classExists("org.gjt.sp.jedit.bsh.classpath.ClassManagerImpl"))
        try {
            // Try to load the module
            // don't refer to it directly here or we're dependent upon it
            Class clas = Class.forName("org.gjt.sp.jedit.bsh.classpath.ClassManagerImpl");
            manager = (BshClassManager) clas.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new InterpreterError("Error loading classmanager: " + e);
        }
    else
        manager = new BshClassManager();
    if (interpreter == null)
        interpreter = new Interpreter();
    manager.declaringInterpreter = interpreter;
    return manager;
}