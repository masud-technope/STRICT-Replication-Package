/*
		Note: this method and resolveExpectedJavaField should be rewritten
		to invert this logic so that no exceptions need to be caught
		unecessarily.  This is just a temporary impl.
		@return the field or null if not found
	*/
protected static Field resolveJavaField(Class clas, String fieldName, boolean staticOnly) throws UtilEvalError {
    try {
        return resolveExpectedJavaField(clas, fieldName, staticOnly);
    } catch (ReflectError e) {
        return null;
    }
}