/**
		Occasionally we need to freeze the callstack for error reporting
		purposes, etc.
	*/
@SuppressWarnings("unchecked")
public CallStack copy() {
    CallStack cs = new CallStack();
    cs.stack = (Vector<NameSpace>) stack.clone();
    return cs;
}