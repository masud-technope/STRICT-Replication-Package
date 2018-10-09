public Class getReturnType() {
    if (returnTypeNode == null)
        return null;
    // BSHType will cache the type for us
    try {
        return returnTypeNode.evalReturnType(callstack, interpreter);
    } catch (EvalError e) {
        throw new InterpreterError("can't eval return type: " + e);
    }
}