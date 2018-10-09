public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    Object ret = null;
    if (evaluateCondition((SimpleNode) jjtGetChild(0), callstack, interpreter))
        ret = ((SimpleNode) jjtGetChild(1)).eval(callstack, interpreter);
    else if (jjtGetNumChildren() > 2)
        ret = ((SimpleNode) jjtGetChild(2)).eval(callstack, interpreter);
    if (ret instanceof ReturnControl)
        return ret;
    else
        return Primitive.VOID;
}