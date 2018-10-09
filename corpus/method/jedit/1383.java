/*
		Notes: This implmenetation of getVariableImpl handles the following
		cases:
		1) var in map not in local scope - var was added through map
		2) var in map and in local scope - var was added through namespace
		3) var not in map but in local scope - var was removed via map
		4) var not in map and not in local scope - non-existent var
	*/
protected Variable getVariableImpl(String name, boolean recurse) throws UtilEvalError {
    // check the external map for the variable name
    Object value = externalMap.get(name);
    Variable var;
    if (value == null) {
        // The var is not in external map and it should therefore not be
        // found in local scope (it may have been removed via the map).  
        // Clear it prophalactically.
        super.unsetVariable(name);
        // Search parent for var if applicable.
        var = super.getVariableImpl(name, recurse);
    } else {
        // Var in external map may be found in local scope with type and
        // modifier info.
        Variable localVar = super.getVariableImpl(name, false);
        // version.
        if (localVar == null)
            var = new Variable(name, (Class) null, value, (Modifiers) null);
        else
            var = localVar;
    }
    return var;
}