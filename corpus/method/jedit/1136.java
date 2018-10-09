Class evalType(CallStack callstack, Interpreter interpreter) throws EvalError {
    BSHType typeNode = getTypeNode();
    return typeNode.getType(callstack, interpreter);
}