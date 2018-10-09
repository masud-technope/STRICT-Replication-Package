/*
		Perform a suffix operation on the given object and return the 
		new value.
		<p>

		obj will be a Node when suffix evaluation begins, allowing us to
		interpret it contextually. (e.g. for .class) Thereafter it will be 
		an value object or LHS (as determined by toLHS).
		<p>
		
		We must handle the toLHS case at each point here.
		<p>
	*/
public Object doSuffix(Object obj, boolean toLHS, CallStack callstack, Interpreter interpreter) throws EvalError {
    // Prefix must be a BSHType
    if (operation == CLASS)
        if (obj instanceof BSHType) {
            if (toLHS)
                throw new EvalError("Can't assign .class", this, callstack);
            NameSpace namespace = callstack.top();
            return ((BSHType) obj).getType(callstack, interpreter);
        } else
            throw new EvalError("Attempt to use .class suffix on non class.", this, callstack);
    /*
			Evaluate our prefix if it needs evaluating first.
			If this is the first evaluation our prefix mayb be a Node 
			(directly from the PrimaryPrefix) - eval() it to an object.  
			If it's an LHS, resolve to a value.

			Note: The ambiguous name construct is now necessary where the node 
			may be an ambiguous name.  If this becomes common we might want to 
			make a static method nodeToObject() or something.  The point is 
			that we can't just eval() - we need to direct the evaluation to 
			the context sensitive type of result; namely object, class, etc.
		*/
    if (obj instanceof SimpleNode)
        if (obj instanceof BSHAmbiguousName)
            obj = ((BSHAmbiguousName) obj).toObject(callstack, interpreter);
        else
            obj = ((SimpleNode) obj).eval(callstack, interpreter);
    else if (obj instanceof LHS)
        try {
            obj = ((LHS) obj).getValue();
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, callstack);
        }
    try {
        switch(operation) {
            case INDEX:
                return doIndex(obj, toLHS, callstack, interpreter);
            case NAME:
                return doName(obj, toLHS, callstack, interpreter);
            case PROPERTY:
                return doProperty(toLHS, obj, callstack, interpreter);
            default:
                throw new InterpreterError("Unknown suffix type");
        }
    } catch (ReflectError e) {
        throw new EvalError("reflection error: " + e, this, callstack);
    } catch (InvocationTargetException e) {
        throw new TargetError("target exception", e.getTargetException(), this, callstack, true);
    }
}