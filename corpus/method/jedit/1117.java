/**
		Helper method for testing equals on two primitive or boxable objects.
		yuck: factor this out into Primitive.java
	*/
private boolean primitiveEquals(Object switchVal, Object targetVal, CallStack callstack, SimpleNode switchExp) throws EvalError {
    if (switchVal instanceof Primitive || targetVal instanceof Primitive)
        try {
            // binaryOperation can return Primitive or wrapper type 
            Object result = Primitive.binaryOperation(switchVal, targetVal, ParserConstants.EQ);
            result = Primitive.unwrap(result);
            return result.equals(Boolean.TRUE);
        } catch (UtilEvalError e) {
            throw e.toEvalError("Switch value: " + switchExp.getText() + ": ", this, callstack);
        }
    else
        return switchVal.equals(targetVal);
}