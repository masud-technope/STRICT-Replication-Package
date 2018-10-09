/**
		Unchecked get for internal use
	*/
Object getu(String name) {
    try {
        return get(name);
    } catch (EvalError e) {
        throw new InterpreterError("set: " + e);
    }
}