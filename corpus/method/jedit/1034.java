/**
        Cache a resolved (possibly overloaded) method based on the
        argument types used to invoke it, subject to classloader change.
        Static and Object methods are cached separately to support fast lookup
        in the general case where either will do.
    */
public void cacheResolvedMethod(Class clas, Class[] types, Method method) {
    if (Interpreter.DEBUG)
        Interpreter.debug("cacheResolvedMethod putting: " + clas + " " + method);
    SignatureKey sk = new SignatureKey(clas, method.getName(), types);
    if (Modifier.isStatic(method.getModifiers()))
        resolvedStaticMethods.put(sk, method);
    else
        resolvedObjectMethods.put(sk, method);
}