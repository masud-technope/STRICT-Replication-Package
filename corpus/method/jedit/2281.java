/**
		Get an LHS reference to an object field.

		This method also deals with the field style property access.
		In the field does not exist we check for a property setter.
	*/
static LHS getLHSObjectField(Object object, String fieldName) throws UtilEvalError, ReflectError {
    if (object instanceof This) {
        // I guess this is when we pass it as an argument?
        // Setting locally
        boolean recurse = false;
        return new LHS(((This) object).namespace, fieldName, recurse);
    }
    try {
        Field f = resolveExpectedJavaField(object.getClass(), fieldName, /*staticOnly*/
        false);
        return new LHS(object, f);
    } catch (ReflectError e) {
        if (hasObjectPropertySetter(object.getClass(), fieldName))
            return new LHS(object, fieldName);
        else
            throw e;
    }
}