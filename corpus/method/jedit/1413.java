/**
		Evaluate the inputstream in this interpreter's global namespace.
	*/
public Object eval(Reader in) throws EvalError {
    return eval(in, globalNameSpace, "eval stream");
}