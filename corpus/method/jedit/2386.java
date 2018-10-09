/**
	 Is the 'from' signature (argument types) assignable to the 'to'
	 signature (candidate method types)
	 This method handles the special case of null values in 'to' types
	 indicating a loose type and matching anything.
	 */
/* Should check for strict java here and limit to isJavaAssignable() */
static boolean isSignatureAssignable(Class[] from, Class[] to, int round) {
    if (round != JAVA_VARARGS_ASSIGNABLE && from.length != to.length)
        return false;
    switch(round) {
        case JAVA_BASE_ASSIGNABLE:
            for (int i = 0; i < from.length; i++) if (!isJavaBaseAssignable(to[i], from[i]))
                return false;
            return true;
        case JAVA_BOX_TYPES_ASSIGABLE:
            for (int i = 0; i < from.length; i++) if (!isJavaBoxTypesAssignable(to[i], from[i]))
                return false;
            return true;
        case JAVA_VARARGS_ASSIGNABLE:
            return isSignatureVarargsAssignable(from, to);
        case BSH_ASSIGNABLE:
            for (int i = 0; i < from.length; i++) if (!isBshAssignable(to[i], from[i]))
                return false;
            return true;
        default:
            throw new InterpreterError("bad case");
    }
}