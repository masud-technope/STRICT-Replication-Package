/**
        This is a helper method for working inside of bsh scripts and commands.
        In that context it is impossible to see a ClassIdentifier object
        for what it is.  Attempting to access a method on a ClassIdentifier
        will look like a static method invocation.

        This method is in NameSpace for convenience (you don't have to import
        bsh.ClassIdentifier to use it );
    */
public static Class identifierToClass(ClassIdentifier ci) {
    return ci.getTargetClass();
}