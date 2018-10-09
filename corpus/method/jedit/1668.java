/**
        Declare a variable in the local scope and set its initial value.
        Value may be null to indicate that we would like the default value
        for the variable type. (e.g.  0 for integer types, null for object
        types).  An existing typed variable may only be set to the same type.
        If an untyped variable of the same name exists it will be overridden
        with the new typed var.
        The set will perform a Types.getAssignableForm() on the value if
        necessary.

        <p>
        Note: this method is primarily intended for use internally.  If you use
        this method outside of the bsh package and wish to set variables with
        primitive values you will have to wrap them using bsh.Primitive.
        @see org.gjt.sp.jedit.bsh.Primitive

        @param value If value is null, you'll get the default value for the type
        @param modifiers may be null
    */
public void setTypedVariable(String name, Class type, Object value, Modifiers modifiers) throws UtilEvalError {
    if (variables == null)
        variables = new Hashtable();
    // Setting a typed variable is always a local operation.
    Variable existing = getVariableImpl(name, false);
    // does the variable already exist?
    if (existing != null) {
        // Is it typed?
        if (existing.getType() != null) {
            // a different (even if assignable) type.
            if (existing.getType() != type) {
                throw new UtilEvalError("Typed variable: " + name + " was previously declared with type: " + existing.getType());
            } else {
                // else set it and return
                existing.setValue(value, Variable.DECLARATION);
                return;
            }
        }
    // Careful here:
    // else fall through to override and install the new typed version
    }
    // Add the new typed var
    variables.put(name, new Variable(name, type, value, modifiers));
}