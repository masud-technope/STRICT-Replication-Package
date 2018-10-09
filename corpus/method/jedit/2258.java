// returns Object covering both Integer and Boolean return types
static Object intBinaryOperation(Integer I1, Integer I2, int kind) {
    int lhs = I1.intValue();
    int rhs = I2.intValue();
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
            return Integer.valueOf(lhs + rhs);
        case MINUS:
            return Integer.valueOf(lhs - rhs);
        case STAR:
            return Integer.valueOf(lhs * rhs);
        case SLASH:
            return Integer.valueOf(lhs / rhs);
        case MOD:
            return Integer.valueOf(lhs % rhs);
        // bitwise
        case LSHIFT:
        case LSHIFTX:
            return Integer.valueOf(lhs << rhs);
        case RSIGNEDSHIFT:
        case RSIGNEDSHIFTX:
            return Integer.valueOf(lhs >> rhs);
        case RUNSIGNEDSHIFT:
        case RUNSIGNEDSHIFTX:
            return Integer.valueOf(lhs >>> rhs);
        case BIT_AND:
        case BIT_ANDX:
            return Integer.valueOf(lhs & rhs);
        case BIT_OR:
        case BIT_ORX:
            return Integer.valueOf(lhs | rhs);
        case XOR:
            return Integer.valueOf(lhs ^ rhs);
        default:
            throw new InterpreterError("Unimplemented binary integer operator");
    }
}