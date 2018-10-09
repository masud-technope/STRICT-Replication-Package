/**
        Get the methods defined in this namespace.
        (This does not show methods in parent namespaces).
        Note: This will probably be renamed getDeclaredMethods()
    */
public BshMethod[] getMethods() {
    if (methods == null)
        return new BshMethod[0];
    else
        return flattenMethodCollection(methods.elements());
}