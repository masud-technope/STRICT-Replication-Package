/**
        Unwrap a variable to its value.
        @return return the variable value.  A null var is mapped to
            Primitive.VOID
    */
protected Object unwrapVariable(Variable var) throws UtilEvalError {
    return (var == null) ? Primitive.VOID : var.getValue();
}