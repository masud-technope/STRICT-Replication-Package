static LHS getLHSStaticField(Class clas, String fieldName) throws UtilEvalError, ReflectError {
    Field f = resolveExpectedJavaField(clas, fieldName, /*onlystatic*/
    true);
    return new LHS(f);
}