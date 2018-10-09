public boolean booleanValue() throws UtilEvalError {
    if (value instanceof Boolean)
        return ((Boolean) value).booleanValue();
    else
        throw new UtilEvalError("Primitive not a boolean");
}