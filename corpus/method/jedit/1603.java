/**
		Invoke a locally declared method or a bsh command.
		If the method is not already declared in the namespace then try
		to load it as a resource from the imported command path (e.g.
		/bsh/commands)
	*/
/*
		Note: the bsh command code should probably not be here...  we need to
		scope it by the namespace that imported the command... so it probably
		needs to be integrated into NameSpace.
	*/
private Object invokeLocalMethod(Interpreter interpreter, Object[] args, CallStack callstack, SimpleNode callerInfo) throws EvalError /*, ReflectError, InvocationTargetException*/
{
    if (Interpreter.DEBUG)
        Interpreter.debug("invokeLocalMethod: " + value);
    if (interpreter == null)
        throw new InterpreterError("invokeLocalMethod: interpreter = null");
    String commandName = value;
    Class[] argTypes = Types.getTypes(args);
    // Check for existing method
    BshMethod meth = null;
    try {
        meth = namespace.getMethod(commandName, argTypes);
    } catch (UtilEvalError e) {
        throw e.toEvalError("Local method invocation", callerInfo, callstack);
    }
    // If defined, invoke it
    if (meth != null)
        return meth.invoke(args, interpreter, callstack, callerInfo);
    BshClassManager bcm = interpreter.getClassManager();
    // Look for a BeanShell command
    Object commandObject;
    try {
        commandObject = namespace.getCommand(commandName, argTypes, interpreter);
    } catch (UtilEvalError e) {
        throw e.toEvalError("Error loading command: ", callerInfo, callstack);
    }
    // should try to print usage here if nothing found
    if (commandObject == null) {
        // Look for a default invoke() handler method in the namespace
        // Note: this code duplicates that in This.java... should it?
        // Call on 'This' can never be a command
        BshMethod invokeMethod = null;
        try {
            invokeMethod = namespace.getMethod("invoke", new Class[] { null, null });
        } catch (UtilEvalError e) {
            throw e.toEvalError("Local method invocation", callerInfo, callstack);
        }
        if (invokeMethod != null)
            return invokeMethod.invoke(new Object[] { commandName, args }, interpreter, callstack, callerInfo);
        throw new EvalError("Command not found: " + StringUtil.methodString(commandName, argTypes), callerInfo, callstack);
    }
    if (commandObject instanceof BshMethod)
        return ((BshMethod) commandObject).invoke(args, interpreter, callstack, callerInfo);
    if (commandObject instanceof Class)
        try {
            return Reflect.invokeCompiledCommand(((Class) commandObject), args, interpreter, callstack);
        } catch (UtilEvalError e) {
            throw e.toEvalError("Error invoking compiled command: ", callerInfo, callstack);
        }
    throw new InterpreterError("invalid command type");
}