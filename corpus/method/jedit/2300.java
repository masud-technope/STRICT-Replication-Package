/**
		Get the candidate methods by searching the class and interface graph
	 	of baseClass and resolve the most specific.
	 	@return the method or null for not found
	 */
private static Method findOverloadedMethod(Class baseClass, String methodName, Class[] types, boolean publicOnly) {
    if (Interpreter.DEBUG)
        Interpreter.debug("Searching for method: " + StringUtil.methodString(methodName, types) + " in '" + baseClass.getName() + "'");
    Method[] methods = getCandidateMethods(baseClass, methodName, types.length, publicOnly);
    if (Interpreter.DEBUG)
        Interpreter.debug("Looking for most specific method: " + methodName);
    Method method = findMostSpecificMethod(types, methods);
    return method;
}