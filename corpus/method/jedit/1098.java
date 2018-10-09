/**
		Evaluate to a value object.
	*/
public LHS toLHS(CallStack callstack, Interpreter interpreter) throws EvalError {
    Object obj = eval(true, callstack, interpreter);
    if (!(obj instanceof LHS))
        throw new EvalError("Can't assign to:", this, callstack);
    else
        return (LHS) obj;
}