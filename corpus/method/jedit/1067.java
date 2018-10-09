/**
		Invoke the declared method with the specified arguments and interpreter
		reference.  This is the simplest form of invoke() for BshMethod 
		intended to be used in reflective style access to bsh scripts.
	*/
public Object invoke(Object[] argValues, Interpreter interpreter) throws EvalError {
    return invoke(argValues, interpreter, null, null, false);
}