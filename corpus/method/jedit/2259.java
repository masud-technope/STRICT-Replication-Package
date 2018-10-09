// returns Object covering both Double and Boolean return types
static Object doubleBinaryOperation(Double D1, Double D2, int kind) throws UtilEvalError {
    double lhs = D1.doubleValue();
    double rhs = D2.doubleValue();
    switch(kind) {
        // boolean
        case LT:
        case LTX:
            return Boolean.valueOf(lhs < rhs);
        case GT:
        case GTX:
            return Boolean.valueOf(lhs > rhs);
        case EQ:
            return Boolean.valueOf(lhs == rhs);
        case LE:
        case LEX:
            return Boolean.valueOf(lhs <= rhs);
        case GE:
        case GEX:
            return Boolean.valueOf(lhs >= rhs);
        case NE:
            return Boolean.valueOf(lhs != rhs);
        // arithmetic
        case PLUS:
            return Double.valueOf(lhs + rhs);
        case MINUS:
            return Double.valueOf(lhs - rhs);
        case STAR:
            return Double.valueOf(lhs * rhs);
        case SLASH:
            return Double.valueOf(lhs / rhs);
        case MOD:
            return Double.valueOf(lhs % rhs);
        // can't shift floating-point values
        case LSHIFT:
        case LSHIFTX:
        case RSIGNEDSHIFT:
        case RSIGNEDSHIFTX:
        case RUNSIGNEDSHIFT:
        case RUNSIGNEDSHIFTX:
            throw new UtilEvalError("Can't shift doubles");
        default:
            throw new InterpreterError("Unimplemented binary double operator");
    }
}