/**
		Get the next object by consuming one or more components of evalName.  
		Often this consumes just one component, but if the name is a classname 
		it will consume all of the components necessary to make the class 
		identifier.
	*/
private Object consumeNextObjectField(CallStack callstack, Interpreter interpreter, boolean forceClass, boolean autoAllocateThis) throws UtilEvalError {
    /*
			Is it a simple variable name?
			Doing this first gives the correct Java precedence for vars 
			vs. imported class names (at least in the simple case - see
			tests/precedence1.bsh).  It should also speed things up a bit.
		*/
    if ((evalBaseObject == null && !isCompound(evalName)) && !forceClass) {
        Object obj = resolveThisFieldReference(callstack, namespace, interpreter, evalName, false);
        if (obj != Primitive.VOID)
            return completeRound(evalName, FINISHED, obj);
    }
    /*
			Is it a bsh script variable reference?
			If we're just starting the eval of name (no base object)
			or we're evaluating relative to a This type reference check.
		*/
    String varName = prefix(evalName, 1);
    if ((evalBaseObject == null || evalBaseObject instanceof This) && !forceClass) {
        if (Interpreter.DEBUG)
            Interpreter.debug("trying to resolve variable: " + varName);
        Object obj;
        // switch namespace and special var visibility
        if (evalBaseObject == null) {
            obj = resolveThisFieldReference(callstack, namespace, interpreter, varName, false);
        } else {
            obj = resolveThisFieldReference(callstack, ((This) evalBaseObject).namespace, interpreter, varName, true);
        }
        if (obj != Primitive.VOID) {
            // Resolved the variable
            if (Interpreter.DEBUG)
                Interpreter.debug("resolved variable: " + varName + " in namespace: " + namespace);
            return completeRound(varName, suffix(evalName), obj);
        }
    }
    /*
			Is it a class name?
			If we're just starting eval of name try to make it, else fail.
		*/
    if (evalBaseObject == null) {
        if (Interpreter.DEBUG)
            Interpreter.debug("trying class: " + evalName);
        /*
				Keep adding parts until we have a class 
			*/
        Class clas = null;
        int i = 1;
        String className = null;
        for (; i <= countParts(evalName); i++) {
            className = prefix(evalName, i);
            if ((clas = namespace.getClass(className)) != null)
                break;
        }
        if (clas != null) {
            return completeRound(className, suffix(evalName, countParts(evalName) - i), new ClassIdentifier(clas));
        }
        // not a class (or variable per above)
        if (Interpreter.DEBUG)
            Interpreter.debug("not a class, trying var prefix " + evalName);
    }
    // if autoAllocateThis then create one; a child 'this'.
    if ((evalBaseObject == null || evalBaseObject instanceof This) && !forceClass && autoAllocateThis) {
        NameSpace targetNameSpace = (evalBaseObject == null) ? namespace : ((This) evalBaseObject).namespace;
        Object obj = new NameSpace(targetNameSpace, "auto: " + varName).getThis(interpreter);
        targetNameSpace.setVariable(varName, obj, false);
        return completeRound(varName, suffix(evalName), obj);
    }
    /*
			If we didn't find a class or variable name (or prefix) above
			there are two possibilities:

			- If we are a simple name then we can pass as a void variable 
			reference.
			- If we are compound then we must fail at this point.
		*/
    if (evalBaseObject == null) {
        if (!isCompound(evalName)) {
            return completeRound(evalName, FINISHED, Primitive.VOID);
        } else
            throw new UtilEvalError("Class or variable not found: " + evalName);
    }
    if (// previous round produced null
    evalBaseObject == Primitive.NULL)
        throw new UtilTargetError(new NullPointerException("Null Pointer while evaluating: " + value));
    if (// previous round produced void
    evalBaseObject == Primitive.VOID)
        throw new UtilEvalError("Undefined variable or class name while evaluating: " + value);
    if (evalBaseObject instanceof Primitive)
        throw new UtilEvalError("Can't treat primitive like an object. " + "Error while evaluating: " + value);
    /* 
			Resolve relative to a class type
			static field, inner class, ?
		*/
    if (evalBaseObject instanceof ClassIdentifier) {
        Class clas = ((ClassIdentifier) evalBaseObject).getTargetClass();
        String field = prefix(evalName, 1);
        // e.g. 'MyOuterClass.this'
        if (field.equals("this")) {
            // find the enclosing class instance space of the class name
            NameSpace ns = namespace;
            while (ns != null) {
                // getClassInstance() throws exception if not there
                if (ns.classInstance != null && ns.classInstance.getClass() == clas)
                    return completeRound(field, suffix(evalName), ns.classInstance);
                ns = ns.getParent();
            }
            throw new UtilEvalError("Can't find enclosing 'this' instance of class: " + clas);
        }
        Object obj = null;
        // static field?
        try {
            if (Interpreter.DEBUG)
                Interpreter.debug("Name call to getStaticFieldValue, class: " + clas + ", field:" + field);
            obj = Reflect.getStaticFieldValue(clas, field);
        } catch (ReflectError e) {
            if (Interpreter.DEBUG)
                Interpreter.debug("field reflect error: " + e);
        }
        // inner class?
        if (obj == null) {
            String iclass = clas.getName() + "$" + field;
            Class c = namespace.getClass(iclass);
            if (c != null)
                obj = new ClassIdentifier(c);
        }
        if (obj == null)
            throw new UtilEvalError("No static field or inner class: " + field + " of " + clas);
        return completeRound(field, suffix(evalName), obj);
    }
    /*
			If we've fallen through here we are no longer resolving to
			a class type.
		*/
    if (forceClass)
        throw new UtilEvalError(value + " does not resolve to a class name.");
    /* 
			Some kind of field access?
		*/
    String field = prefix(evalName, 1);
    // length access on array? 
    if (field.equals("length") && evalBaseObject.getClass().isArray()) {
        Object obj = new Primitive(Array.getLength(evalBaseObject));
        return completeRound(field, suffix(evalName), obj);
    }
    // Note: could eliminate throwing the exception somehow
    try {
        Object obj = Reflect.getObjectFieldValue(evalBaseObject, field);
        return completeRound(field, suffix(evalName), obj);
    } catch (ReflectError /* not a field */
    e) {
    }
    // if we get here we have failed
    throw new UtilEvalError("Cannot access field: " + field + ", on object: " + evalBaseObject);
}