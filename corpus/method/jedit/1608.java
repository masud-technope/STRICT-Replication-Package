/**
		Resolve a variable relative to a This reference.

		This is the general variable resolution method, accomodating special
		fields from the This context.  Together the namespace and interpreter
		comprise the This context.  The callstack, if available allows for the
		this.caller construct.  
		Optionally interpret special "magic" field names: e.g. interpreter.
		<p/>

		@param callstack may be null, but this is only legitimate in special
		cases where we are sure resolution will not involve this.caller.

		@param namespace the namespace of the this reference (should be the
		same as the top of the stack?
	*/
Object resolveThisFieldReference(CallStack callstack, NameSpace thisNameSpace, Interpreter interpreter, String varName, boolean specialFieldsVisible) throws UtilEvalError {
    if (varName.equals("this")) {
        /*
				Somewhat of a hack.  If the special fields are visible (we're
				operating relative to a 'this' type already) dissallow further
				.this references to prevent user from skipping to things like
				super.this.caller
			*/
        if (specialFieldsVisible)
            throw new UtilEvalError("Redundant to call .this on This type");
        // Allow getThis() to work through BlockNameSpace to the method
        // namespace
        // XXX re-eval this... do we need it?
        This ths = thisNameSpace.getThis(interpreter);
        thisNameSpace = ths.getNameSpace();
        Object result = ths;
        NameSpace classNameSpace = getClassNameSpace(thisNameSpace);
        if (classNameSpace != null) {
            if (isCompound(evalName))
                result = classNameSpace.getThis(interpreter);
            else
                result = classNameSpace.getClassInstance();
        }
        return result;
    }
    /*
			Some duplication for "super".  See notes for "this" above
			If we're in an enclsing class instance and have a superclass
			instance our super is the superclass instance.
		*/
    if (varName.equals("super")) {
        //if ( specialFieldsVisible )
        //throw new UtilEvalError("Redundant to call .this on This type");
        // Allow getSuper() to through BlockNameSpace to the method's super
        This ths = thisNameSpace.getSuper(interpreter);
        thisNameSpace = ths.getNameSpace();
        // then super means our parent.
        if (thisNameSpace.getParent() != null && thisNameSpace.getParent().isClass)
            ths = thisNameSpace.getParent().getThis(interpreter);
        return ths;
    }
    Object obj = null;
    if (varName.equals("global"))
        obj = thisNameSpace.getGlobal(interpreter);
    if (obj == null && specialFieldsVisible) {
        if (varName.equals("namespace"))
            obj = thisNameSpace;
        else if (varName.equals("variables"))
            obj = thisNameSpace.getVariableNames();
        else if (varName.equals("methods"))
            obj = thisNameSpace.getMethodNames();
        else if (varName.equals("interpreter"))
            if (lastEvalName.equals("this"))
                obj = interpreter;
            else
                throw new UtilEvalError("Can only call .interpreter on literal 'this'");
    }
    if (obj == null && specialFieldsVisible && varName.equals("caller")) {
        if (lastEvalName.equals("this") || lastEvalName.equals("caller")) {
            // get the previous context (see notes for this class)
            if (callstack == null)
                throw new InterpreterError("no callstack");
            obj = callstack.get(++callstackDepth).getThis(interpreter);
        } else
            throw new UtilEvalError("Can only call .caller on literal 'this' or literal '.caller'");
        // early return
        return obj;
    }
    if (obj == null && specialFieldsVisible && varName.equals("callstack")) {
        if (lastEvalName.equals("this")) {
            // get the previous context (see notes for this class)
            if (callstack == null)
                throw new InterpreterError("no callstack");
            obj = callstack;
        } else
            throw new UtilEvalError("Can only call .callstack on literal 'this'");
    }
    if (obj == null)
        obj = thisNameSpace.getVariable(varName);
    if (obj == null)
        throw new InterpreterError("null this field ref:" + varName);
    return obj;
}