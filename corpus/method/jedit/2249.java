// returns Object covering both Long and Boolean return types
static Object floatBinaryOperation(Float F1, Float F2, int kind) throws UtilEvalError {
    float lhs = F1.floatValue();
    float rhs = F2.floatValue();
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
            return Float.valueOf(lhs + rhs);
        case MINUS:
            return Float.valueOf(lhs - rhs);
        case STAR:
            return Float.valueOf(lhs * rhs);
        case SLASH:
            return Float.valueOf(lhs / rhs);
        case MOD:
            return Float.valueOf(lhs % rhs);
        // can't shift floats
        case LSHIFT:
        case LSHIFTX:
        case RSIGNEDSHIFT:
        case RSIGNEDSHIFTX:
        case RUNSIGNEDSHIFT:
        case RUNSIGNEDSHIFTX:
            throw new UtilEvalError("Can't shift floats ");
        default:
            throw new InterpreterError("Unimplemented binary float operator");
    }
}