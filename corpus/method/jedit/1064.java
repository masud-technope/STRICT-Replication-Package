public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    if (value == null)
        throw new InterpreterError("Null in bsh literal: " + value);
    return value;
}