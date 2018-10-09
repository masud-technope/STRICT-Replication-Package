/**
		Set the value of the typed variable.
		@param value should be an object or wrapped bsh Primitive type.
		if value is null the appropriate default value will be set for the
		type: e.g. false for boolean, zero for integer types.
	*/
public void setValue(Object value, int context) throws UtilEvalError {
    // check this.value
    if (hasModifier("final") && this.value != null)
        throw new UtilEvalError("Final variable, can't re-assign.");
    if (value == null)
        value = Primitive.getDefaultValue(type);
    if (lhs != null) {
        lhs.assign(value, /*strictjava*/
        false);
        return;
    }
    // (as opposed to isJavaAssignable())
    if (type != null)
        value = Types.castObject(value, type, context == DECLARATION ? Types.CAST : Types.ASSIGNMENT);
    this.value = value;
}