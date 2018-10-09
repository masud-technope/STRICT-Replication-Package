public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    return eval(callstack, interpreter, false);
}