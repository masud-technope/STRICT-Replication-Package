/*
		The interpretation of an ambiguous name is context sensitive.
		We disallow a generic eval( ).
	*/
public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    throw new InterpreterError("Don't know how to eval an ambiguous name!" + "  Use toObject() if you want an object.");
}