/**
        Get the names of variables defined in this namespace.
        (This does not show variables in parent namespaces).
    */
public String[] getVariableNames() {
    if (variables == null)
        return new String[0];
    else
        return enumerationToStringArray(variables.keys());
}