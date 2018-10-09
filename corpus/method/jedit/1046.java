/**
		Evaluate the type.
	*/
public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    if (jjtGetNumChildren() > 0)
        type = ((BSHType) jjtGetChild(0)).getType(callstack, interpreter);
    else
        type = UNTYPED;
    return type;
}