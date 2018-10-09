/**
		Evaluate to a value object.
	*/
public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    return eval(false, callstack, interpreter);
}