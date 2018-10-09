/**
		This method wraps resolveJavaMethod() and expects a non-null method
	 	result. If the method is not found it throws a descriptive ReflectError.
	*/
protected static Method resolveExpectedJavaMethod(BshClassManager bcm, Class clas, Object object, String name, Object[] args, boolean staticOnly) throws ReflectError, UtilEvalError {
    if (object == Primitive.NULL)
        throw new UtilTargetError(new NullPointerException("Attempt to invoke method " + name + " on null value"));
    Class[] types = Types.getTypes(args);
    Method method = resolveJavaMethod(bcm, clas, name, types, staticOnly);
    if (method == null)
        throw new ReflectError((staticOnly ? "Static method " : "Method ") + StringUtil.methodString(name, types) + " not found in class'" + clas.getName() + "'");
    return method;
}