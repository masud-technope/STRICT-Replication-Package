public Object toObject(CallStack callstack, Interpreter interpreter) throws EvalError {
    return toObject(callstack, interpreter, false);
}