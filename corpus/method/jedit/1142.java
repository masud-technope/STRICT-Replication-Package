public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    SimpleNode node = (SimpleNode) jjtGetChild(0);
    // just do the unary operation for the value.
    try {
        if (kind == INCR || kind == DECR) {
            LHS lhs = ((BSHPrimaryExpression) node).toLHS(callstack, interpreter);
            return lhsUnaryOperation(lhs, interpreter.getStrictJava());
        } else
            return unaryOperation(node.eval(callstack, interpreter), kind);
    } catch (UtilEvalError e) {
        throw e.toEvalError(this, callstack);
    }
}