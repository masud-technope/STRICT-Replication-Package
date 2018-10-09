/**
        Get the specified variable in this namespace or a parent namespace.
        <p>
        Note: this method is primarily intended for use internally.  If you use
        this method outside of the bsh package you will have to use
        Primitive.unwrap() to get primitive values.
        @see Primitive#unwrap( Object )

        @return The variable value or Primitive.VOID if it is not defined.
    */
public Object getVariable(String name) throws UtilEvalError {
    return getVariable(name, true);
}