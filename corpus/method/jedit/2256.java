static Boolean booleanBinaryOperation(Boolean B1, Boolean B2, int kind) {
    boolean lhs = B1.booleanValue();
    boolean rhs = B2.booleanValue();
    switch(kind) {
        case EQ:
            return Boolean.valueOf(lhs == rhs);
        case NE:
            return Boolean.valueOf(lhs != rhs);
        case BOOL_OR:
        case BOOL_ORX:
            return Boolean.valueOf(lhs || rhs);
        case BOOL_AND:
        case BOOL_ANDX:
            return Boolean.valueOf(lhs && rhs);
        default:
            throw new InterpreterError("unimplemented binary operator");
    }
}