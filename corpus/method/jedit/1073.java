private Object invokeImpl(Object[] argValues, Interpreter interpreter, CallStack callstack, SimpleNode callerInfo, boolean overrideNameSpace) throws EvalError {
    Class returnType = getReturnType();
    Class[] paramTypes = getParameterTypes();
    // If null callstack
    if (callstack == null)
        callstack = new CallStack(declaringNameSpace);
    if (argValues == null)
        argValues = new Object[] {};
    // Cardinality (number of args) mismatch
    if (argValues.length != numArgs) {
        /*
			// look for help string
			try {
				// should check for null namespace here
				String help = 
					(String)declaringNameSpace.get(
					"bsh.help."+name, interpreter );

				interpreter.println(help);
				return Primitive.VOID;
			} catch ( Exception e ) {
				throw eval error
			}
		*/
        throw new EvalError("Wrong number of arguments for local method: " + name, callerInfo, callstack);
    }
    // Make the local namespace for the method invocation
    NameSpace localNameSpace;
    if (overrideNameSpace)
        localNameSpace = callstack.top();
    else {
        localNameSpace = new NameSpace(declaringNameSpace, name);
        localNameSpace.isMethod = true;
    }
    // should we do this for both cases above?
    localNameSpace.setNode(callerInfo);
    // set the method parameters in the local namespace
    for (int i = 0; i < numArgs; i++) {
        // Set typed variable
        if (paramTypes[i] != null) {
            try {
                argValues[i] = //Types.getAssignableForm( argValues[i], paramTypes[i] );
                Types.castObject(argValues[i], paramTypes[i], Types.ASSIGNMENT);
            } catch (UtilEvalError e) {
                throw new EvalError("Invalid argument: " + "`" + paramNames[i] + "'" + " for method: " + name + " : " + e.getMessage(), callerInfo, callstack);
            }
            try {
                localNameSpace.setTypedVariable(paramNames[i], paramTypes[i], /*modifiers*/
                argValues[i], null);
            } catch (UtilEvalError e2) {
                throw e2.toEvalError("Typed method parameter assignment", callerInfo, callstack);
            }
        } else // Set untyped variable
        // untyped param
        {
            // getAssignable would catch this for typed param
            if (argValues[i] == Primitive.VOID)
                throw new EvalError("Undefined variable or class name, parameter: " + paramNames[i] + " to method: " + name, callerInfo, callstack);
            else
                try {
                    localNameSpace.setLocalVariable(paramNames[i], argValues[i], interpreter.getStrictJava());
                } catch (UtilEvalError e3) {
                    throw e3.toEvalError(callerInfo, callstack);
                }
        }
    }
    // Push the new namespace on the call stack
    if (!overrideNameSpace)
        callstack.push(localNameSpace);
    // Invoke the block, overriding namespace with localNameSpace
    Object ret = methodBody.eval(callstack, interpreter, /*override*/
    true);
    // save the callstack including the called method, just for error mess
    CallStack returnStack = callstack.copy();
    // Get back to caller namespace
    if (!overrideNameSpace)
        callstack.pop();
    ReturnControl retControl = null;
    if (ret instanceof ReturnControl) {
        retControl = (ReturnControl) ret;
        // Method body can only use 'return' statment type return control.
        if (retControl.kind == retControl.RETURN)
            ret = ((ReturnControl) ret).value;
        else
            // retControl.returnPoint is the Node of the return statement
            throw new EvalError("'continue' or 'break' in method body", retControl.returnPoint, returnStack);
        // retControl.returnPoint is the Node of the return statement
        if (returnType == Void.TYPE && ret != Primitive.VOID)
            throw new EvalError("Cannot return value from void method", retControl.returnPoint, returnStack);
    }
    if (returnType != null) {
        // If return type void, return void as the value.
        if (returnType == Void.TYPE)
            return Primitive.VOID;
        // return type is a class
        try {
            ret = // Types.getAssignableForm( ret, (Class)returnType );
            Types.castObject(ret, returnType, Types.ASSIGNMENT);
        } catch (UtilEvalError e) {
            SimpleNode node = callerInfo;
            if (retControl != null)
                node = retControl.returnPoint;
            throw e.toEvalError("Incorrect type returned from method: " + name + e.getMessage(), node, callstack);
        }
    }
    return ret;
}