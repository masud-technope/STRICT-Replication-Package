/**
		Perform a binary operation on two Primitives or wrapper types.
		If both original args were Primitives return a Primitive result
		else it was mixed (wrapper/primitive) return the wrapper type.
		The exception is for boolean operations where we will return the 
		primitive type either way.
	*/
public static Object binaryOperation(Object obj1, Object obj2, int kind) throws UtilEvalError {
    // special primitive types
    if (obj1 == NULL || obj2 == NULL)
        throw new UtilEvalError("Null value or 'null' literal in binary operation");
    if (obj1 == VOID || obj2 == VOID)
        throw new UtilEvalError("Undefined variable, class, or 'void' literal in binary operation");
    // keep track of the original types
    Class lhsOrgType = obj1.getClass();
    Class rhsOrgType = obj2.getClass();
    // Unwrap primitives
    if (obj1 instanceof Primitive)
        obj1 = ((Primitive) obj1).getValue();
    if (obj2 instanceof Primitive)
        obj2 = ((Primitive) obj2).getValue();
    Object[] operands = promotePrimitives(obj1, obj2);
    Object lhs = operands[0];
    Object rhs = operands[1];
    if (lhs.getClass() != rhs.getClass())
        throw new UtilEvalError("Type mismatch in operator.  " + lhs.getClass() + " cannot be used with " + rhs.getClass());
    Object result;
    try {
        result = binaryOperationImpl(lhs, rhs, kind);
    } catch (ArithmeticException e) {
        throw new UtilTargetError("Arithemetic Exception in binary op", e);
    }
    // Exception is for boolean result, return the primitive
    if ((lhsOrgType == Primitive.class && rhsOrgType == Primitive.class) || result instanceof Boolean)
        return new Primitive(result);
    else
        return result;
}