private Object lhsUnaryOperation(LHS lhs, boolean strictJava) throws UtilEvalError {
    if (Interpreter.DEBUG)
        Interpreter.debug("lhsUnaryOperation");
    Object prevalue, postvalue;
    prevalue = lhs.getValue();
    postvalue = unaryOperation(prevalue, kind);
    Object retVal;
    if (postfix)
        retVal = prevalue;
    else
        retVal = postvalue;
    lhs.assign(postvalue, strictJava);
    return retVal;
}