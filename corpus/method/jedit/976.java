public LHS toLHS(CallStack callstack, Interpreter interpreter) throws EvalError {
    try {
        return getName(callstack.top()).toLHS(callstack, interpreter);
    } catch (UtilEvalError e) {
        throw e.toEvalError(this, callstack);
    }
}