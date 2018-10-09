/**
        A command is a scripted method or compiled command class implementing a
        specified method signature.  Commands are loaded from the classpath
        and may be imported using the importCommands() method.
        <p>

        This method searches the imported commands packages for a script or
        command object corresponding to the name of the method.  If it is a
        script the script is sourced into this namespace and the BshMethod for
        the requested signature is returned.  If it is a compiled class the
        class is returned.  (Compiled command classes implement static invoke()
        methods).
        <p>

        The imported packages are searched in reverse order, so that later
        imports take priority.
        Currently only the first object (script or class) with the appropriate
        name is checked.  If another, overloaded form, is located in another
        package it will not currently be found.  This could be fixed.
        <p>

        @return a BshMethod, Class, or null if no such command is found.
        @param name is the name of the desired command method
        @param argTypes is the signature of the desired command method.
        @throws UtilEvalError if loadScriptedCommand throws UtilEvalError
            i.e. on errors loading a script that was found
    */
// {{{ jEdit's getCommand
public Object getCommand(String name, Class[] argTypes, Interpreter interpreter) throws UtilEvalError {
    if (Interpreter.DEBUG)
        Interpreter.debug("getCommand: " + name);
    BshClassManager bcm = interpreter.getClassManager();
    InputStream in = getCommand(name);
    if (in != null)
        return loadScriptedCommand(in, name, argTypes, name, interpreter);
    if (parent != null)
        return parent.getCommand(name, argTypes, interpreter);
    else
        return null;
}