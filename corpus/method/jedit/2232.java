/*
		Cast or check a cast of a primitive type to another type.
		Normally both types are primitive (e.g. numeric), but a null value
		(no type) may be cast to any type.
		<p/>

		@param toType is the target type of the cast.  It is normally a
		java primitive TYPE, but in the case of a null cast can be any object
		type.

		@param fromType is the java primitive TYPE type of the primitive to be
		cast or null, to indicate that the fromValue was null or void.

		@param fromValue is, optionally, the value to be converted.  If
		checkOnly is true fromValue must be null.  If checkOnly is false,
		fromValue must be non-null (Primitive.NULL is of course valid).
	*/
static Primitive castPrimitive(Class toType, Class fromType, Primitive fromValue, boolean checkOnly, int operation) throws UtilEvalError {
    /*
			Lots of preconditions checked here...
			Once things are running smoothly we might comment these out
			(That's what assertions are for).
		*/
    if (checkOnly && fromValue != null)
        throw new InterpreterError("bad cast param 1");
    if (!checkOnly && fromValue == null)
        throw new InterpreterError("bad cast param 2");
    if (fromType != null && !fromType.isPrimitive())
        throw new InterpreterError("bad fromType:" + fromType);
    if (fromValue == Primitive.NULL && fromType != null)
        throw new InterpreterError("inconsistent args 1");
    if (fromValue == Primitive.VOID && fromType != Void.TYPE)
        throw new InterpreterError("inconsistent args 2");
    // can't cast void to anything
    if (fromType == Void.TYPE)
        if (checkOnly)
            return Types.INVALID_CAST;
        else
            throw Types.castError(Reflect.normalizeClassName(toType), "void value", operation);
    // unwrap Primitive fromValue to its wrapper value, etc.
    Object value = null;
    if (fromValue != null)
        value = fromValue.getValue();
    if (toType.isPrimitive()) {
        // Trying to cast null to primitive type?
        if (fromType == null)
            if (checkOnly)
                return Types.INVALID_CAST;
            else
                throw Types.castError("primitive type:" + toType, "Null value", operation);
    // fall through
    } else {
        // Primitive.NULL can be cast to any object type
        if (fromType == null)
            return checkOnly ? Types.VALID_CAST : Primitive.NULL;
        if (checkOnly)
            return Types.INVALID_CAST;
        else
            throw Types.castError("object type:" + toType, "primitive value", operation);
    }
    // can only cast boolean to boolean
    if (fromType == Boolean.TYPE) {
        if (toType != Boolean.TYPE)
            if (checkOnly)
                return Types.INVALID_CAST;
            else
                throw Types.castError(toType, fromType, operation);
        return checkOnly ? Types.VALID_CAST : fromValue;
    }
    // Only allow legal Java assignment unless we're a CAST operation
    if (operation == Types.ASSIGNMENT && !Types.isJavaAssignable(toType, fromType)) {
        if (checkOnly)
            return Types.INVALID_CAST;
        else
            throw Types.castError(toType, fromType, operation);
    }
    return checkOnly ? Types.VALID_CAST : new Primitive(castWrapper(toType, value));
}