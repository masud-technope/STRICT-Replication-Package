public static Object invokeSuperclassMethodImpl(BshClassManager bcm, Object instance, String methodName, Object[] args) throws UtilEvalError, ReflectError, InvocationTargetException {
    String superName = ClassGeneratorUtil.BSHSUPER + methodName;
    // look for the specially named super delegate method
    Class clas = instance.getClass();
    Method superMethod = Reflect.resolveJavaMethod(bcm, clas, superName, Types.getTypes(args), /*onlyStatic*/
    false);
    if (superMethod != null)
        return Reflect.invokeMethod(superMethod, instance, args);
    // No super method, try to invoke regular method
    // could be a superfluous "super." which is legal.
    Class superClass = clas.getSuperclass();
    superMethod = Reflect.resolveExpectedJavaMethod(bcm, superClass, instance, methodName, args, /*onlyStatic*/
    false);
    return Reflect.invokeMethod(superMethod, instance, args);
}