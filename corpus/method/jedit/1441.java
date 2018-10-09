/**
		Unassign the variable name.
		Name should evaluate to a variable.
	*/
public void unset(String name) throws EvalError {
    /*
			We jump through some hoops here to handle arbitrary cases like
			unset("bsh.foo");
		*/
    CallStack callstack = new CallStack();
    try {
        LHS lhs = globalNameSpace.getNameResolver(name).toLHS(callstack, this);
        if (lhs.type != LHS.VARIABLE)
            throw new EvalError("Can't unset, not a variable: " + name, SimpleNode.JAVACODE, new CallStack());
        //lhs.assign( null, false );
        lhs.nameSpace.unsetVariable(name);
    } catch (UtilEvalError e) {
        throw new EvalError(e.getMessage(), SimpleNode.JAVACODE, new CallStack());
    }
}