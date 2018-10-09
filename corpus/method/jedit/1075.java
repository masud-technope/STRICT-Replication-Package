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
	*/
public Object invoke(Object[] argValues, Interpreter interpreter, CallStack callstack, SimpleNode callerInfo) throws EvalError {
    return invoke(argValues, interpreter, callstack, callerInfo, false);
}