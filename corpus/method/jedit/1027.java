/**
        Perform a plain Class.forName() or call the externally provided
        classloader.
        If a BshClassManager implementation is loaded the call will be
        delegated to it, to allow for additional hooks.
        <p>

        This simply wraps that bottom level class lookup call and provides a
        central point for monitoring and handling certain Java version
        dependent bugs, etc.

        @see #classForName( String )
        @return the class
    */
public Class plainClassForName(String name) throws ClassNotFoundException {
    Class c = null;
    try {
        if (externalClassLoader != null)
            c = externalClassLoader.loadClass(name);
        else
            c = Class.forName(name);
        cacheClassInfo(name, c);
    /*
            Original note: Jdk under Win is throwing these to
            warn about lower case / upper case possible mismatch.
            e.g. bsh.console bsh.Console

            Update: Prior to 1.3 we were squeltching NoClassDefFoundErrors
            which was very annoying.  I cannot reproduce the original problem
            and this was never a valid solution.  If there are legacy VMs that
            have problems we can include a more specific test for them here.
        */
    } catch (NoClassDefFoundError e) {
        throw noClassDefFound(name, e);
    }
    return c;
}