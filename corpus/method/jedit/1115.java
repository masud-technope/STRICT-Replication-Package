public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    if (isDefault)
        // should probably error
        return null;
    SimpleNode label = ((SimpleNode) jjtGetChild(0));
    return label.eval(callstack, interpreter);
}