/**
        Return a previously cached resolved method.
        @param onlyStatic specifies that only a static method may be returned.
        @return the Method or null
    */
protected Method getResolvedMethod(Class clas, String methodName, Class[] types, boolean onlyStatic) {
    SignatureKey sk = new SignatureKey(clas, methodName, types);
    // Try static and then object, if allowed
    // Note that the Java compiler should not allow both.
    Method method = (Method) resolvedStaticMethods.get(sk);
    if (method == null && !onlyStatic)
        method = (Method) resolvedObjectMethods.get(sk);
    if (Interpreter.DEBUG) {
        if (method == null)
            Interpreter.debug("getResolvedMethod cache MISS: " + clas + " - " + methodName);
        else
            Interpreter.debug("getResolvedMethod cache HIT: " + clas + " - " + method);
    }
    return method;
}