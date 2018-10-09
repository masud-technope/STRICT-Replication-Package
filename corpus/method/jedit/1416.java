/**
		Evaluate the string in this interpreter's global namespace.
	*/
public Object eval(String statements) throws EvalError {
    if (Interpreter.DEBUG)
        debug("eval(String): " + statements);
    return eval(statements, globalNameSpace);
}