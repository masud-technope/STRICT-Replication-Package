/**
		Check the cache, else use toObject() to try to resolve to a class
		identifier.  

		@throws ClassNotFoundException on class not found.
		@throws ClassPathException (type of EvalError) on special case of 
		ambiguous unqualified name after super import. 
	*/
public synchronized Class toClass() throws ClassNotFoundException, UtilEvalError {
    if (asClass != null)
        return asClass;
    reset();
    // "var" means untyped, return null class
    if (evalName.equals("var"))
        return asClass = null;
    /* Try straightforward class name first */
    Class clas = namespace.getClass(evalName);
    if (clas == null) {
        /* 
				Try toObject() which knows how to work through inner classes
				and see what we end up with 
			*/
        Object obj = null;
        try {
            // Null interpreter and callstack references.
            // class only resolution should not require them.
            obj = toObject(null, null, true);
        }// couldn't resolve it
         catch (UtilEvalError e) {
        }
        // couldn't resolve it
        ;
        if (obj instanceof ClassIdentifier)
            clas = ((ClassIdentifier) obj).getTargetClass();
    }
    if (clas == null)
        throw new ClassNotFoundException("Class: " + value + " not found in namespace");
    asClass = clas;
    return asClass;
}