/**
	*/
static int getIndexAux(Object obj, CallStack callstack, Interpreter interpreter, SimpleNode callerInfo) throws EvalError {
    if (!obj.getClass().isArray())
        throw new EvalError("Not an array", callerInfo, callstack);
    int index;
    try {
        Object indexVal = ((SimpleNode) callerInfo.jjtGetChild(0)).eval(callstack, interpreter);
        if (!(indexVal instanceof Primitive))
            indexVal = Types.castObject(indexVal, Integer.TYPE, Types.ASSIGNMENT);
        index = ((Primitive) indexVal).intValue();
    } catch (UtilEvalError e) {
        Interpreter.debug("doIndex: " + e);
        throw e.toEvalError("Arrays may only be indexed by integer types.", callerInfo, callstack);
    }
    return index;
}