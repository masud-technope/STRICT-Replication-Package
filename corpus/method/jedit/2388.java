static UtilEvalError castError(String lhs, String rhs, int operation) {
    if (operation == ASSIGNMENT)
        return new UtilEvalError("Can't assign " + rhs + " to " + lhs);
    Exception cce = new ClassCastException("Cannot cast " + rhs + " to " + lhs);
    return new UtilTargetError(cce);
}