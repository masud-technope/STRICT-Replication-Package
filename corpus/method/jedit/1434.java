/**
		Assign the value to the name.
		name may evaluate to anything assignable. e.g. a variable or field.
	*/
public void set(String name, Object value) throws EvalError {
    // map null to Primtive.NULL coming in...
    if (value == null)
        value = Primitive.NULL;
    CallStack callstack = new CallStack();
    try {
        if (Name.isCompound(name)) {
            LHS lhs = globalNameSpace.getNameResolver(name).toLHS(callstack, this);
            lhs.assign(value, false);
        } else
            // optimization for common case
            globalNameSpace.setVariable(name, value, false);
    } catch (UtilEvalError e) {
        throw e.toEvalError(SimpleNode.JAVACODE, callstack);
    }
}