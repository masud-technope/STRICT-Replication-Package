public Class evalReturnType(CallStack callstack, Interpreter interpreter) throws EvalError {
    if (isVoid)
        return Void.TYPE;
    else
        return getTypeNode().getType(callstack, interpreter);
}