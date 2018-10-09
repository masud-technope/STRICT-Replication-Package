private static Object getFieldValue(Class clas, Object object, String fieldName, boolean staticOnly) throws UtilEvalError, ReflectError {
    try {
        Field f = resolveExpectedJavaField(clas, fieldName, staticOnly);
        Object value = f.get(object);
        Class returnType = f.getType();
        return Primitive.wrap(value, returnType);
    } catch (NullPointerException // shouldn't happen
    e) {
        throw new ReflectError("???" + fieldName + " is not a static field.");
    } catch (IllegalAccessException e) {
        throw new ReflectError("Can't access field: " + fieldName);
    }
}