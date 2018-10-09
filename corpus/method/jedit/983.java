public Object eval(Class type, CallStack callstack, Interpreter interpreter) throws EvalError {
    if (Interpreter.DEBUG)
        Interpreter.debug("array base type = " + type);
    baseType = type;
    return eval(callstack, interpreter);
}