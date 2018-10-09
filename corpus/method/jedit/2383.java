/**
		Is the assignment legal via original Java (up to version 1.4)
		assignment rules, not including auto-boxing/unboxing.
	 @param rhsType may be null to indicate primitive null value
	*/
static boolean isJavaBaseAssignable(Class lhsType, Class rhsType) {
    /*
			Assignment to loose type, defer to bsh extensions
			Note: we could shortcut this here:
			if ( lhsType == null ) return true;
			rather than forcing another round.  It's not strictly a Java issue,
			so does it belong here?
		*/
    if (lhsType == null)
        return false;
    // assignable to any object type
    if (rhsType == null)
        return !lhsType.isPrimitive();
    if (lhsType.isPrimitive() && rhsType.isPrimitive()) {
        if (lhsType == rhsType)
            return true;
        // handle primitive widening conversions - JLS 5.1.2
        if ((rhsType == Byte.TYPE) && (lhsType == Short.TYPE || lhsType == Integer.TYPE || lhsType == Long.TYPE || lhsType == Float.TYPE || lhsType == Double.TYPE))
            return true;
        if ((rhsType == Short.TYPE) && (lhsType == Integer.TYPE || lhsType == Long.TYPE || lhsType == Float.TYPE || lhsType == Double.TYPE))
            return true;
        if ((rhsType == Character.TYPE) && (lhsType == Integer.TYPE || lhsType == Long.TYPE || lhsType == Float.TYPE || lhsType == Double.TYPE))
            return true;
        if ((rhsType == Integer.TYPE) && (lhsType == Long.TYPE || lhsType == Float.TYPE || lhsType == Double.TYPE))
            return true;
        if ((rhsType == Long.TYPE) && (lhsType == Float.TYPE || lhsType == Double.TYPE))
            return true;
        if ((rhsType == Float.TYPE) && (lhsType == Double.TYPE))
            return true;
    } else if (lhsType.isAssignableFrom(rhsType))
        return true;
    return false;
}