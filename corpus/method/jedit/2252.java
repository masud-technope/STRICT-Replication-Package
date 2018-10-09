public static Primitive unaryOperation(Primitive val, int kind) throws UtilEvalError {
    if (val == NULL)
        throw new UtilEvalError("illegal use of null object or 'null' literal");
    if (val == VOID)
        throw new UtilEvalError("illegal use of undefined object or 'void' literal");
    Class operandType = val.getType();
    Object operand = promoteToInteger(val.getValue());
    if (operand instanceof Boolean)
        return new Primitive(booleanUnaryOperation((Boolean) operand, kind));
    else if (operand instanceof Integer) {
        int result = intUnaryOperation((Integer) operand, kind);
        // ++ and -- must be cast back the original type
        if (kind == INCR || kind == DECR) {
            if (operandType == Byte.TYPE)
                return new Primitive((byte) result);
            if (operandType == Short.TYPE)
                return new Primitive((short) result);
            if (operandType == Character.TYPE)
                return new Primitive((char) result);
        }
        return new Primitive(result);
    } else if (operand instanceof Long)
        return new Primitive(longUnaryOperation((Long) operand, kind));
    else if (operand instanceof Float)
        return new Primitive(floatUnaryOperation((Float) operand, kind));
    else if (operand instanceof Double)
        return new Primitive(doubleUnaryOperation((Double) operand, kind));
    else
        throw new InterpreterError("An error occurred.  Please call technical support.");
}