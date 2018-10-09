/**
		Invoke method on arbitrary object instance.
		invocation may be static (through the object instance) or dynamic.
		Object may be a bsh scripted object (bsh.This type).
	 	@return the result of the method call
	*/
public static Object invokeObjectMethod(Object object, String methodName, Object[] args, Interpreter interpreter, CallStack callstack, SimpleNode callerInfo) throws ReflectError, EvalError, InvocationTargetException {
    // Bsh scripted object
    if (object instanceof This && !This.isExposedThisMethod(methodName))
        return ((This) object).invokeMethod(methodName, args, interpreter, callstack, callerInfo, /*delcaredOnly*/
        false);
    // Plain Java object, find the java method
    try {
        BshClassManager bcm = interpreter == null ? null : interpreter.getClassManager();
        Class clas = object.getClass();
        Method method = resolveExpectedJavaMethod(bcm, clas, object, methodName, args, false);
        return invokeMethod(method, object, args);
    } catch (UtilEvalError e) {
        throw e.toEvalError(callerInfo, callstack);
    }
}