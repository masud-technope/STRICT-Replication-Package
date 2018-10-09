public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    BSHPrimaryExpression lhsNode = (BSHPrimaryExpression) jjtGetChild(0);
    if (lhsNode == null)
        throw new InterpreterError("Error, null LHSnode");
    boolean strictJava = interpreter.getStrictJava();
    LHS lhs = lhsNode.toLHS(callstack, interpreter);
    if (lhs == null)
        throw new InterpreterError("Error, null LHS");
    // For operator-assign operations save the lhs value before evaluating
    // the rhs.  This is correct Java behavior for postfix operations
    // e.g. i=1; i+=i++; // should be 2 not 3
    Object lhsValue = null;
    if (// assign doesn't need the pre-value
    operator != ASSIGN)
        try {
            lhsValue = lhs.getValue();
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, callstack);
        }
    SimpleNode rhsNode = (SimpleNode) jjtGetChild(1);
    Object rhs;
    // implement "blocks" foo = { };
    // if ( rhsNode instanceof BSHBlock )
    //    rsh =
    // else
    rhs = rhsNode.eval(callstack, interpreter);
    if (rhs == Primitive.VOID)
        throw new EvalError("Void assignment.", this, callstack);
    try {
        switch(operator) {
            case ASSIGN:
                return lhs.assign(rhs, strictJava);
            case PLUSASSIGN:
                return lhs.assign(operation(lhsValue, rhs, PLUS), strictJava);
            case MINUSASSIGN:
                return lhs.assign(operation(lhsValue, rhs, MINUS), strictJava);
            case STARASSIGN:
                return lhs.assign(operation(lhsValue, rhs, STAR), strictJava);
            case SLASHASSIGN:
                return lhs.assign(operation(lhsValue, rhs, SLASH), strictJava);
            case ANDASSIGN:
            case ANDASSIGNX:
                return lhs.assign(operation(lhsValue, rhs, BIT_AND), strictJava);
            case ORASSIGN:
            case ORASSIGNX:
                return lhs.assign(operation(lhsValue, rhs, BIT_OR), strictJava);
            case XORASSIGN:
                return lhs.assign(operation(lhsValue, rhs, XOR), strictJava);
            case MODASSIGN:
                return lhs.assign(operation(lhsValue, rhs, MOD), strictJava);
            case LSHIFTASSIGN:
            case LSHIFTASSIGNX:
                return lhs.assign(operation(lhsValue, rhs, LSHIFT), strictJava);
            case RSIGNEDSHIFTASSIGN:
            case RSIGNEDSHIFTASSIGNX:
                return lhs.assign(operation(lhsValue, rhs, RSIGNEDSHIFT), strictJava);
            case RUNSIGNEDSHIFTASSIGN:
            case RUNSIGNEDSHIFTASSIGNX:
                return lhs.assign(operation(lhsValue, rhs, RUNSIGNEDSHIFT), strictJava);
            default:
                throw new InterpreterError("unimplemented operator in assignment BSH");
        }
    } catch (UtilEvalError e) {
        throw e.toEvalError(this, callstack);
    }
}