/**
		Evaluate the declaration of the method.  That is, determine the
		structure of the method and install it into the caller's namespace.
	*/
public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    returnType = evalReturnType(callstack, interpreter);
    evalNodes(callstack, interpreter);
    // Install an *instance* of this method in the namespace.
    // See notes in BshMethod 
    // This is not good...
    // need a way to update eval without re-installing...
    // so that we can re-eval params, etc. when classloader changes
    // look into this
    NameSpace namespace = callstack.top();
    BshMethod bshMethod = new BshMethod(this, namespace, modifiers);
    try {
        namespace.setMethod(name, bshMethod);
    } catch (UtilEvalError e) {
        throw e.toEvalError(this, callstack);
    }
    return Primitive.VOID;
}