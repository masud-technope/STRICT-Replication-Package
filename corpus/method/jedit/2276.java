/** 
		Invoke a method known to be static.
		No object instance is needed and there is no possibility of the 
		method being a bsh scripted method.
	*/
public static Object invokeStaticMethod(BshClassManager bcm, Class clas, String methodName, Object[] args) throws ReflectError, UtilEvalError, InvocationTargetException {
    Interpreter.debug("invoke static Method");
    Method method = resolveExpectedJavaMethod(bcm, clas, null, methodName, args, true);
    return invokeMethod(method, null, args);
}