/**
		Invoke the bsh method with the specified args, interpreter ref,
		and callstack.
		callerInfo is the node representing the method invocation
		It is used primarily for debugging in order to provide access to the 
		text of the construct that invoked the method through the namespace.
		@param callerInfo is the BeanShell AST node representing the method 
			invocation.  It is used to print the line number and text of 
			errors in EvalError exceptions.  If the node is null here error
			messages may not be able to point to the precise location and text
			of the error.
		@param callstack is the callstack.  If callstack is null a new one
			will be created with the declaring namespace of the method on top
			of the stack (i.e. it will look for purposes of the method 
			invocation like the method call occurred in the declaring 
			(enclosing) namespace in which the method is defined).
		@param overrideNameSpace 
			When true the method is executed in the namespace on the top of the
			stack instead of creating its own local namespace.  This allows it
			to be used in constructors.
	*/
Object invoke(Object[] argValues, Interpreter interpreter, CallStack callstack, SimpleNode callerInfo, boolean overrideNameSpace) throws EvalError {
    if (argValues != null)
        for (int i = 0; i < argValues.length; i++) if (argValues[i] == null)
            throw new Error("HERE!");
    if (javaMethod != null)
        try {
            return Reflect.invokeMethod(javaMethod, javaObject, argValues);
        } catch (ReflectError e) {
            throw new EvalError("Error invoking Java method: " + e, callerInfo, callstack);
        } catch (InvocationTargetException e2) {
            throw new TargetError("Exception invoking imported object method.", e2, callerInfo, callstack, true);
        }
    // is this a syncrhonized method?
    if (modifiers != null && modifiers.hasModifier("synchronized")) {
        // The lock is our declaring namespace's This reference
        // (the method's 'super').  Or in the case of a class it's the
        // class instance.
        Object lock;
        if (declaringNameSpace.isClass) {
            try {
                lock = declaringNameSpace.getClassInstance();
            } catch (UtilEvalError e) {
                throw new InterpreterError("Can't get class instance for synchronized method.");
            }
        } else
            lock = // ???
            declaringNameSpace.getThis(// ???
            interpreter);
        synchronized (lock) {
            return invokeImpl(argValues, interpreter, callstack, callerInfo, overrideNameSpace);
        }
    } else
        return invokeImpl(argValues, interpreter, callstack, callerInfo, overrideNameSpace);
}