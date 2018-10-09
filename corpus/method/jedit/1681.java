/**
        Load a class through this namespace taking into account imports.
        The class search will proceed through the parent namespaces if
        necessary.

        @return null if not found.
    */
public Class getClass(String name) throws UtilEvalError {
    Class c = getClassImpl(name);
    if (c != null)
        return c;
    else // implement the recursion for getClassImpl()
    if (parent != null)
        return parent.getClass(name);
    else
        return null;
}