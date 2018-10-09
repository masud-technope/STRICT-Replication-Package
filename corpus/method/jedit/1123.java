public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    Object obj = ((SimpleNode) jjtGetChild(0)).eval(callstack, interpreter);
    // that in interpreter somewhere?  check first...
    if (!(obj instanceof Exception))
        throw new EvalError("Expression in 'throw' must be Exception type", this, callstack);
    // wrap the exception in a TargetException to propogate it up
    throw new TargetError((Exception) obj, this, callstack);
}