/**
		array index.
		Must handle toLHS case.
	*/
private Object doIndex(Object obj, boolean toLHS, CallStack callstack, Interpreter interpreter) throws EvalError, ReflectError {
    int index = getIndexAux(obj, callstack, interpreter, this);
    if (toLHS)
        return new LHS(obj, index);
    else
        try {
            return Reflect.getIndex(obj, index);
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, callstack);
        }
}