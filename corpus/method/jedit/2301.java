/**
        The full blown resolver method.  All other method invocation methods
		delegate to this.  The method may be static or dynamic unless
		staticOnly is set (in which case object may be null).
		If staticOnly is set then only static methods will be located.
		<p/>

		This method performs caching (caches discovered methods through the
	 	class manager and utilizes cached methods.)
	 	<p/>

	 	This method determines whether to attempt to use non-public methods
	 	based on Capabilities.haveAccessibility() and will set the accessibilty
	 	flag on the method as necessary.
	 	<p/>

		If, when directed to find a static method, this method locates a more 
		specific matching instance method it will throw a descriptive exception 
		analogous to the error that the Java compiler would produce.
		Note: as of 2.0.x this is a problem because there is no way to work
		around this with a cast. 
		<p/>

		@param staticOnly
			The method located must be static, the object param may be null.
		@return the method or null if no matching method was found.
	*/
protected static Method resolveJavaMethod(BshClassManager bcm, Class clas, String name, Class[] types, boolean staticOnly) throws UtilEvalError {
    if (clas == null)
        throw new InterpreterError("null class");
    // Lookup previously cached method
    Method method = null;
    if (bcm == null)
        Interpreter.debug("resolveJavaMethod UNOPTIMIZED lookup");
    else
        method = bcm.getResolvedMethod(clas, name, types, staticOnly);
    if (method == null) {
        boolean publicOnly = !Capabilities.haveAccessibility();
        // Searching for the method may, itself be a priviledged action
        try {
            method = findOverloadedMethod(clas, name, types, publicOnly);
        } catch (SecurityException e) {
            throw new UtilTargetError("Security Exception while searching methods of: " + clas, e);
        }
        checkFoundStaticMethod(method, staticOnly, clas);
        // non-public class
        if (method != null && !publicOnly) {
            try {
                ReflectManager.RMSetAccessible(method);
            } catch (UtilEvalError /*ignore*/
            e) {
            }
        }
        // If succeeded cache the resolved method.
        if (method != null && bcm != null)
            bcm.cacheResolvedMethod(clas, types, method);
    }
    return method;
}