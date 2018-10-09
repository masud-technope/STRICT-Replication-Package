// returns Object covering both Long and Boolean return types
static Object longBinaryOperation(Long L1, Long L2, int kind) {
    long lhs = L1.longValue();
    long rhs = L2.longValue();
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
            return Long.valueOf(lhs + rhs);
        case MINUS:
            return Long.valueOf(lhs - rhs);
        case STAR:
            return Long.valueOf(lhs * rhs);
        case SLASH:
            return Long.valueOf(lhs / rhs);
        case MOD:
            return Long.valueOf(lhs % rhs);
        // bitwise
        case LSHIFT:
        case LSHIFTX:
            return Long.valueOf(lhs << rhs);
        case RSIGNEDSHIFT:
        case RSIGNEDSHIFTX:
            return Long.valueOf(lhs >> rhs);
        case RUNSIGNEDSHIFT:
        case RUNSIGNEDSHIFTX:
            return Long.valueOf(lhs >>> rhs);
        case BIT_AND:
        case BIT_ANDX:
            return Long.valueOf(lhs & rhs);
        case BIT_OR:
        case BIT_ORX:
            return Long.valueOf(lhs | rhs);
        case XOR:
            return Long.valueOf(lhs ^ rhs);
        default:
            throw new InterpreterError("Unimplemented binary long operator");
    }
}