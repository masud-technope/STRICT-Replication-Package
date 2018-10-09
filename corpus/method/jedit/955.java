/**
		Override the standard namespace behavior to make assignments
		happen in our parent (enclosing) namespace, unless the variable has
		already been assigned here via a typed declaration or through
		the special setBlockVariable() (used for untyped args in try/catch).
		<p>
		i.e. only allow typed var declaration to happen in this namespace.
		Typed vars are handled in the ordinary way local scope.  All untyped
		assignments are delegated to the enclosing context.
	*/
/*
		Note: it may see like with the new 1.3 scoping this test could be
		removed, but it cannot.  When recurse is false we still need to set the
		variable in our parent, not here.
	*/
public void setVariable(String name, Object value, boolean strictJava, boolean recurse) throws UtilEvalError {
    if (weHaveVar(name))
        // set the var here in the block namespace
        super.setVariable(name, value, strictJava, false);
    else
        // set the var in the enclosing (parent) namespace
        getParent().setVariable(name, value, strictJava, recurse);
}