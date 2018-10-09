/**
		Evaluate the return type node.
		@return the type or null indicating loosely typed return
	*/
Class evalReturnType(CallStack callstack, Interpreter interpreter) throws EvalError {
    insureNodesParsed();
    if (returnTypeNode != null)
        return returnTypeNode.evalReturnType(callstack, interpreter);
    else
        return null;
}