/**
		@return the result of the cast.
	*/
public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    NameSpace namespace = callstack.top();
    Class toType = ((BSHType) jjtGetChild(0)).getType(callstack, interpreter);
    SimpleNode expression = (SimpleNode) jjtGetChild(1);
    // evaluate the expression
    Object fromValue = expression.eval(callstack, interpreter);
    Class fromType = fromValue.getClass();
    // (as opposed to isJavaAssignable())
    try {
        return Types.castObject(fromValue, toType, Types.CAST);
    } catch (UtilEvalError e) {
        throw e.toEvalError(this, callstack);
    }
}