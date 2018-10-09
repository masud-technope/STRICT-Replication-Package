/**
		Cast a primitive value represented by its java.lang wrapper type to the
		specified java.lang wrapper type.  e.g.  Byte(5) to Integer(5) or
		Integer(5) to Byte(5) 
		@param toType is the java TYPE type
		@param value is the value in java.lang wrapper.
		value may not be null.
	*/
static Object castWrapper(Class toType, Object value) {
    if (!toType.isPrimitive())
        throw new InterpreterError("invalid type in castWrapper: " + toType);
    if (value == null)
        throw new InterpreterError("null value in castWrapper, guard");
    if (value instanceof Boolean) {
        if (toType != Boolean.TYPE)
            throw new InterpreterError("bad wrapper cast of boolean");
        else
            return value;
    }
    // first promote char to Number type to avoid duplicating code
    if (value instanceof Character)
        value = Integer.valueOf(((Character) value).charValue());
    if (!(value instanceof Number))
        throw new InterpreterError("bad type in cast");
    Number number = (Number) value;
    if (toType == Byte.TYPE)
        return Byte.valueOf(number.byteValue());
    if (toType == Short.TYPE)
        return Short.valueOf(number.shortValue());
    if (toType == Character.TYPE)
        return Character.valueOf((char) number.intValue());
    if (toType == Integer.TYPE)
        return Integer.valueOf(number.intValue());
    if (toType == Long.TYPE)
        return Long.valueOf(number.longValue());
    if (toType == Float.TYPE)
        return Float.valueOf(number.floatValue());
    if (toType == Double.TYPE)
        return Double.valueOf(number.doubleValue());
    throw new InterpreterError("error in wrapper cast");
}