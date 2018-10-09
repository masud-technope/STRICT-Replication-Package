static boolean booleanUnaryOperation(Boolean B, int kind) throws UtilEvalError {
    boolean operand = B.booleanValue();
    switch(kind) {
        case BANG:
            return !operand;
        default:
            throw new UtilEvalError("Operator inappropriate for boolean");
    }
}