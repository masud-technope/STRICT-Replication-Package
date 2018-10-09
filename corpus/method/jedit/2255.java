static Object binaryOperationImpl(Object lhs, Object rhs, int kind) throws UtilEvalError {
    if (lhs instanceof Boolean)
        return booleanBinaryOperation((Boolean) lhs, (Boolean) rhs, kind);
    else if (lhs instanceof Integer)
        return intBinaryOperation((Integer) lhs, (Integer) rhs, kind);
    else if (lhs instanceof Long)
        return longBinaryOperation((Long) lhs, (Long) rhs, kind);
    else if (lhs instanceof Float)
        return floatBinaryOperation((Float) lhs, (Float) rhs, kind);
    else if (lhs instanceof Double)
        return doubleBinaryOperation((Double) lhs, (Double) rhs, kind);
    else
        throw new UtilEvalError("Invalid types in binary operator");
}