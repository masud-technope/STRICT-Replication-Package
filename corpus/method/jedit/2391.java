/**
	 Test if a type can be converted to another type via BeanShell
	 extended syntax rules (a superset of Java conversion rules).
	 */
static boolean isBshAssignable(Class toType, Class fromType) {
    try {
        return castObject(toType, /*fromValue*/
        fromType, null, ASSIGNMENT, /*checkOnly*/
        true) == VALID_CAST;
    } catch (UtilEvalError e) {
        throw new InterpreterError("err in cast check: " + e);
    }
}