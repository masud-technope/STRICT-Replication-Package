/**
		A command may be implemented as a compiled Java class containing one or
		more static invoke() methods of the correct signature.  The invoke()
		methods must accept two additional leading arguments of the interpreter
		and callstack, respectively. e.g. invoke(interpreter, callstack, ... )
		This method adds the arguments and invokes the static method, returning
		the result.
	*/
public static Object invokeCompiledCommand(Class commandClass, Object[] args, Interpreter interpreter, CallStack callstack) throws UtilEvalError {
    // add interpereter and namespace to args list
    Object[] invokeArgs = new Object[args.length + 2];
    invokeArgs[0] = interpreter;
    invokeArgs[1] = callstack;
    System.arraycopy(args, 0, invokeArgs, 2, args.length);
    BshClassManager bcm = interpreter.getClassManager();
    try {
        return Reflect.invokeStaticMethod(bcm, commandClass, "invoke", invokeArgs);
    } catch (InvocationTargetException e) {
        throw new UtilEvalError("Error in compiled command: " + e.getTargetException());
    } catch (ReflectError e) {
        throw new UtilEvalError("Error invoking compiled command: " + e);
    }
}