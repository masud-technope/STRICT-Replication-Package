public Number numberValue() throws UtilEvalError {
    Object value = this.value;
    // Promote character to Number type for these purposes
    if (value instanceof Character)
        value = Integer.valueOf(((Character) value).charValue());
    if (value instanceof Number)
        return (Number) value;
    else
        throw new UtilEvalError("Primitive not a number");
}