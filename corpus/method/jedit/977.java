public Class toClass(CallStack callstack, Interpreter interpreter) throws EvalError {
    try {
        return getName(callstack.top()).toClass();
    } catch (ClassNotFoundException e) {
        throw new EvalError(e.getMessage(), this, callstack);
    } catch (UtilEvalError e2) {
        throw e2.toEvalError(this, callstack);
    }
}