/**
		Promote primitive wrapper type to to Integer wrapper type
	*/
static Object promoteToInteger(Object wrapper) {
    if (wrapper instanceof Character)
        return Integer.valueOf(((Character) wrapper).charValue());
    else if ((wrapper instanceof Byte) || (wrapper instanceof Short))
        return Integer.valueOf(((Number) wrapper).intValue());
    return wrapper;
}