private Object operation(Object lhs, Object rhs, int kind) throws UtilEvalError {
    /*
			Implement String += value;
			According to the JLS, value may be anything.
			In BeanShell, we'll disallow VOID (undefined) values.
			(or should we map them to the empty string?)
		*/
    if (lhs instanceof String && rhs != Primitive.VOID) {
        if (kind != PLUS)
            throw new UtilEvalError("Use of non + operator with String LHS");
        return (String) lhs + rhs;
    }
    if (lhs instanceof Primitive || rhs instanceof Primitive)
        if (lhs == Primitive.VOID || rhs == Primitive.VOID)
            throw new UtilEvalError("Illegal use of undefined object or 'void' literal");
        else if (lhs == Primitive.NULL || rhs == Primitive.NULL)
            throw new UtilEvalError("Illegal use of null object or 'null' literal");
    if ((lhs instanceof Boolean || lhs instanceof Character || lhs instanceof Number || lhs instanceof Primitive) && (rhs instanceof Boolean || rhs instanceof Character || rhs instanceof Number || rhs instanceof Primitive)) {
        return Primitive.binaryOperation(lhs, rhs, kind);
    }
    throw new UtilEvalError("Non primitive value in operator: " + lhs.getClass() + " " + tokenImage[kind] + " " + rhs.getClass());
}