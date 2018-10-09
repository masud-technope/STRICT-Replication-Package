/**
        Set a variable explicitly in the local scope.
    */
void setLocalVariable(String name, Object value, boolean strictJava) throws UtilEvalError {
    setVariable(name, value, strictJava, false);
}