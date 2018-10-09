/**
		This is the general signature for evaluation of a node.
	*/
public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    throw new InterpreterError("Unimplemented or inappropriate for " + getClass().getName());
}