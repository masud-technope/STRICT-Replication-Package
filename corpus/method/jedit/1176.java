public Object invokeSuperclassMethod(BshClassManager bcm, Object instance, String methodName, Object[] args) throws UtilEvalError, ReflectError, InvocationTargetException {
    // Delegate to the static method
    return invokeSuperclassMethodImpl(bcm, instance, methodName, args);
}