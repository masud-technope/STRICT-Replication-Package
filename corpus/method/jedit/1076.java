/*
		Create a BshMethod that delegates to a real Java method upon invocation.
		This is used to represent imported object methods.
	*/
 BshMethod(Method method, Object object) {
    this(method.getName(), method.getReturnType(), /*paramNames*/
    null, method.getParameterTypes(), /*method.block*/
    null, /*declaringNameSpace*/
    null, /*modifiers*/
    null);
    this.javaMethod = method;
    this.javaObject = object;
}