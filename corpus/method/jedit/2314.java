public static Object getObjectProperty(Object obj, String propName) throws UtilEvalError, ReflectError {
    Object[] args = new Object[] {};
    Interpreter.debug("property access: ");
    Method method = null;
    Exception e1 = null, e2 = null;
    try {
        String accessorName = accessorName("get", propName);
        method = resolveExpectedJavaMethod(/*bcm*/
        null, obj.getClass(), obj, accessorName, args, false);
    } catch (Exception e) {
        e1 = e;
    }
    if (method == null)
        try {
            String accessorName = accessorName("is", propName);
            method = resolveExpectedJavaMethod(/*bcm*/
            null, obj.getClass(), obj, accessorName, args, false);
            if (method.getReturnType() != Boolean.TYPE)
                method = null;
        } catch (Exception e) {
            e2 = e;
        }
    if (method == null)
        throw new ReflectError("Error in property getter: " + e1 + (e2 != null ? " : " + e2 : ""));
    try {
        return invokeMethod(method, obj, args);
    } catch (InvocationTargetException e) {
        throw new UtilEvalError("Property accessor threw exception: " + e.getTargetException());
    }
}