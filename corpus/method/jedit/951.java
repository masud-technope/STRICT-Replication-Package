/**
		We have the variable: either it was declared here with a type, giving
		it block local scope or an untyped var was explicitly set here via
		setBlockVariable().
	*/
private boolean weHaveVar(String name) {
    // super.variables.containsKey( name ) not any faster, I checked
    try {
        return super.getVariableImpl(name, false) != null;
    } catch (UtilEvalError e) {
        return false;
    }
}