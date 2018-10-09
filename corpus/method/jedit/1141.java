private Object primitiveWrapperUnaryOperation(Object val, int kind) throws UtilEvalError {
    Class operandType = val.getClass();
    Object operand = Primitive.promoteToInteger(val);
    if (operand instanceof Boolean)
        return Boolean.valueOf(Primitive.booleanUnaryOperation((Boolean) operand, kind));
    else if (operand instanceof Integer) {
        int result = Primitive.intUnaryOperation((Integer) operand, kind);
        // ++ and -- must be cast back the original type
        if (kind == INCR || kind == DECR) {
            if (operandType == Byte.TYPE)
                return Byte.valueOf((byte) result);
            if (operandType == Short.TYPE)
                return Short.valueOf((short) result);
            if (operandType == Character.TYPE)
                return Character.valueOf((char) result);
        }
        return Integer.valueOf(result);
    } else if (operand instanceof Long)
        return Long.valueOf(Primitive.longUnaryOperation((Long) operand, kind));
    else if (operand instanceof Float)
        return Float.valueOf(Primitive.floatUnaryOperation((Float) operand, kind));
    else if (operand instanceof Double)
        return Double.valueOf(Primitive.doubleUnaryOperation((Double) operand, kind));
    else
        throw new InterpreterError("An error occurred.  Please call technical support.");
}