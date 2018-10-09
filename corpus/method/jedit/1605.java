/**
		@see toObject()
		@param forceClass if true then resolution will only produce a class.
		This is necessary to disambiguate in cases where the grammar knows
		that we want a class; where in general the var path may be taken.
	*/
public synchronized Object toObject(CallStack callstack, Interpreter interpreter, boolean forceClass) throws UtilEvalError {
    reset();
    Object obj = null;
    while (evalName != null) obj = consumeNextObjectField(callstack, interpreter, forceClass, /*autoalloc*/
    false);
    if (obj == null)
        throw new InterpreterError("null value in toObject()");
    return obj;
}