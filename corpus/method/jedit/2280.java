public static Object getStaticFieldValue(Class clas, String fieldName) throws UtilEvalError, ReflectError {
    return getFieldValue(clas, null, fieldName, true);
}