public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    throw new EvalError("Array initializer has no base type.", this, callstack);
}