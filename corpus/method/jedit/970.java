Object toObject(CallStack callstack, Interpreter interpreter, boolean forceClass) throws EvalError {
    try {
        return getName(callstack.top()).toObject(callstack, interpreter, forceClass);
    } catch (UtilEvalError e) {
        throw e.toEvalError(this, callstack);
    }
}