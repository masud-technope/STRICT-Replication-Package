/*
        The real implementation in the classpath.ClassManagerImpl handles
        reloading of the generated classes.
    */
public Class defineClass(String name, byte[] code) {
    throw new InterpreterError("Can't create class (" + name + ") without class manager package.");
/*
        Old implementation injected classes into the parent classloader.
        This was incorrect behavior for several reasons.  The biggest problem
        is that classes could therefore only be defined once across all
        executions of the script...

        ClassLoader cl = this.getClass().getClassLoader();
        Class clas;
        try {
            clas = (Class)Reflect.invokeObjectMethod(
                cl, "defineClass",
                new Object [] {
                    name, code,
                    new Primitive( (int)0 )/offset/,
                    new Primitive( code.length )/len/
                },
                (Interpreter)null, (CallStack)null, (SimpleNode)null
            );
        } catch ( Exception e ) {
            e.printStackTrace();
            throw new InterpreterError("Unable to define class: "+ e );
        }
        absoluteNonClasses.remove( name ); // may have been axed previously
        return clas;
    */
}