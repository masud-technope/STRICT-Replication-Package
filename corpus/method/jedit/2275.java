/**
		Invoke the Java method on the specified object, performing needed
	 	type mappings on arguments and return values.
		@param args may be null
	*/
static Object invokeMethod(Method method, Object object, Object[] args) throws ReflectError, InvocationTargetException {
    if (args == null)
        args = new Object[0];
    logInvokeMethod("Invoking method (entry): ", method, args);
    // Map types to assignable forms, need to keep this fast...
    Object[] tmpArgs = new Object[args.length];
    Class[] types = method.getParameterTypes();
    try {
        for (int i = 0; i < args.length; i++) tmpArgs[i] = Types.castObject(/*rhs*/
        args[i], /*lhsType*/
        types[i], Types.ASSIGNMENT);
    } catch (UtilEvalError e) {
        throw new InterpreterError("illegal argument type in method invocation: " + e);
    }
    // unwrap any primitives
    tmpArgs = Primitive.unwrap(tmpArgs);
    logInvokeMethod("Invoking method (after massaging values): ", method, tmpArgs);
    try {
        Object returnValue = method.invoke(object, tmpArgs);
        if (returnValue == null)
            returnValue = Primitive.NULL;
        Class returnType = method.getReturnType();
        return Primitive.wrap(returnValue, returnType);
    } catch (IllegalAccessException e) {
        throw new ReflectError("Cannot access method " + StringUtil.methodString(method.getName(), method.getParameterTypes()) + " in '" + method.getDeclaringClass() + "' :" + e);
    }
}