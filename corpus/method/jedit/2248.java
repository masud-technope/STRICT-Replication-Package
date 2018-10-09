public int intValue() throws UtilEvalError {
    if (value instanceof Number)
        return ((Number) value).intValue();
    else
        throw new UtilEvalError("Primitive not a number");
}