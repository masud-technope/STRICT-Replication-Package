/*
		Note: UtilEvalError here comes from lhs.getValue().
		A Variable can represent an LHS for the case of an imported class or
		object field.
	*/
Object getValue() throws UtilEvalError {
    if (lhs != null)
        return lhs.getValue();
    return value;
}