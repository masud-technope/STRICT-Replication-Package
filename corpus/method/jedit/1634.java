/**
        Get the names of methods declared in this namespace.
        (This does not include methods in parent namespaces).
    */
public String[] getMethodNames() {
    if (methods == null)
        return new String[0];
    else
        return enumerationToStringArray(methods.keys());
}