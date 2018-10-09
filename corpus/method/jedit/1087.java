private void evalNodes(CallStack callstack, Interpreter interpreter) throws EvalError {
    insureNodesParsed();
    // validate that the throws names are class names
    for (int i = firstThrowsClause; i < numThrows + firstThrowsClause; i++) ((BSHAmbiguousName) jjtGetChild(i)).toClass(callstack, interpreter);
    paramsNode.eval(callstack, interpreter);
    // if strictJava mode, check for loose parameters and return type
    if (interpreter.getStrictJava()) {
        for (int i = 0; i < paramsNode.paramTypes.length; i++) if (paramsNode.paramTypes[i] == null)
            // a stack trace to indicate how we sourced the method.
            throw new EvalError("(Strict Java Mode) Undeclared argument type, parameter: " + paramsNode.getParamNames()[i] + " in method: " + name, this, null);
        if (returnType == null)
            // a stack trace to indicate how we sourced the method.
            throw new EvalError("(Strict Java Mode) Undeclared return type for method: " + name, this, null);
    }
}