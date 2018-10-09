/*
	*/
public synchronized LHS toLHS(CallStack callstack, Interpreter interpreter) throws UtilEvalError {
    // Should clean this up to a single return statement
    reset();
    LHS lhs;
    // Simple (non-compound) variable assignment e.g. x=5;
    if (!isCompound(evalName)) {
        if (evalName.equals("this"))
            throw new UtilEvalError("Can't assign to 'this'.");
        // Interpreter.debug("Simple var LHS...");
        lhs = new LHS(namespace, evalName, /*bubble up if allowed*/
        false);
        return lhs;
    }
    // Field e.g. foo.bar=5;
    Object obj = null;
    try {
        while (evalName != null && isCompound(evalName)) {
            obj = consumeNextObjectField(callstack, interpreter, /*forcclass*/
            false, /*autoallocthis*/
            true);
        }
    } catch (UtilEvalError e) {
        throw new UtilEvalError("LHS evaluation: " + e.getMessage());
    }
    // Finished eval and its a class.
    if (evalName == null && obj instanceof ClassIdentifier)
        throw new UtilEvalError("Can't assign to class: " + value);
    if (obj == null)
        throw new UtilEvalError("Error in LHS: " + value);
    // e.g. this.x=5;  or someThisType.x=5;
    if (obj instanceof This) {
        // dissallow assignment to magic fields
        if (evalName.equals("namespace") || evalName.equals("variables") || evalName.equals("methods") || evalName.equals("caller"))
            throw new UtilEvalError("Can't assign to special variable: " + evalName);
        Interpreter.debug("found This reference evaluating LHS");
        /*
				If this was a literal "super" reference then we allow recursion
				in setting the variable to get the normal effect of finding the
				nearest definition starting at the super scope.  On any other
				resolution qualified by a 'this' type reference we want to set
				the variable directly in that scope. e.g. this.x=5;  or 
				someThisType.x=5;
				
				In the old scoping rules super didn't do this.
			*/
        boolean localVar = !lastEvalName.equals("super");
        return new LHS(((This) obj).namespace, evalName, localVar);
    }
    if (evalName != null) {
        try {
            if (obj instanceof ClassIdentifier) {
                Class clas = ((ClassIdentifier) obj).getTargetClass();
                lhs = Reflect.getLHSStaticField(clas, evalName);
                return lhs;
            } else {
                lhs = Reflect.getLHSObjectField(obj, evalName);
                return lhs;
            }
        } catch (ReflectError e) {
            throw new UtilEvalError("Field access: " + e);
        }
    }
    throw new InterpreterError("Internal error in lhs...");
}