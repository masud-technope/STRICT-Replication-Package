/**
		Unchecked set for internal use
	*/
void setu(String name, Object value) {
    try {
        set(name, value);
    } catch (EvalError e) {
        throw new InterpreterError("set: " + e);
    }
}