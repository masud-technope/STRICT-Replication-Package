/**
        Get the specified variable in this namespace.
        @param recurse If recurse is true then we recursively search through
        parent namespaces for the variable.
        <p>
        Note: this method is primarily intended for use internally.  If you use
        this method outside of the bsh package you will have to use
        Primitive.unwrap() to get primitive values.
        @see Primitive#unwrap( Object )

        @return The variable value or Primitive.VOID if it is not defined.
    */
public Object getVariable(String name, boolean recurse) throws UtilEvalError {
    Variable var = getVariableImpl(name, recurse);
    return unwrapVariable(var);
}