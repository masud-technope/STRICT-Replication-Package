public static void setObjectProperty(Object obj, String propName, Object value) throws ReflectError, UtilEvalError {
    String accessorName = accessorName("set", propName);
    Object[] args = new Object[] { value };
    Interpreter.debug("property access: ");
    try {
        Method method = resolveExpectedJavaMethod(/*bcm*/
        null, obj.getClass(), obj, accessorName, args, false);
        invokeMethod(method, obj, args);
    } catch (InvocationTargetException e) {
        throw new UtilEvalError("Property accessor threw exception: " + e.getTargetException());
    }
}