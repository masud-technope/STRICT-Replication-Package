/**
        Set the value of a the variable 'name' through this namespace.
        The variable may be an existing or non-existing variable.
        It may live in this namespace or in a parent namespace if recurse is
        true.
        <p>
        Note: This method is not public and does *not* know about LOCALSCOPING.
        Its caller methods must set recurse intelligently in all situations
        (perhaps based on LOCALSCOPING).

        <p>
        Note: this method is primarily intended for use internally.  If you use
        this method outside of the bsh package and wish to set variables with
        primitive values you will have to wrap them using bsh.Primitive.
        @see org.gjt.sp.jedit.bsh.Primitive
        <p>
        Setting a new variable (which didn't exist before) or removing
        a variable causes a namespace change.

        @param strictJava specifies whether strict java rules are applied.
        @param recurse determines whether we will search for the variable in
          our parent's scope before assigning locally.
    */
void setVariable(String name, Object value, boolean strictJava, boolean recurse) throws UtilEvalError {
    if (variables == null)
        variables = new Hashtable();
    if (value == null) {
        // don't break jEdit core and plugins!
        unsetVariable(name);
        return;
    }
    // }}}
    // Locate the variable definition if it exists.
    Variable existing = getVariableImpl(name, recurse);
    // Found an existing variable here (or above if recurse allowed)
    if (existing != null) {
        try {
            existing.setValue(value, Variable.ASSIGNMENT);
        } catch (UtilEvalError e) {
            throw new UtilEvalError("Variable assignment: " + name + ": " + e.getMessage());
        }
    } else // No previous variable definition found here (or above if recurse)
    {
        if (strictJava)
            throw new UtilEvalError("(Strict Java mode) Assignment to undeclared variable: " + name);
        // If recurse, set global untyped var, else set it here.
        //NameSpace varScope = recurse ? getGlobal() : this;
        // This modification makes default allocation local
        NameSpace varScope = this;
        varScope.variables.put(name, new Variable(name, value, null));
        // nameSpaceChanged() on new variable addition
        nameSpaceChanged();
    }
}