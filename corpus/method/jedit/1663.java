/**
        Locate a variable and return the Variable object with optional
        recursion through parent name spaces.
        <p>
        If this namespace is static, return only static variables.

        @return the Variable value or null if it is not defined
    */
protected Variable getVariableImpl(String name, boolean recurse) throws UtilEvalError {
    Variable var = null;
    // Get imported first.
    if (var == null && isClass)
        var = getImportedVar(name);
    if (var == null && variables != null)
        var = (Variable) variables.get(name);
    // Change import precedence if we are a class body/instance
    if (var == null && !isClass)
        var = getImportedVar(name);
    // try parent
    if (recurse && (var == null) && (parent != null))
        var = parent.getVariableImpl(name, recurse);
    return var;
}