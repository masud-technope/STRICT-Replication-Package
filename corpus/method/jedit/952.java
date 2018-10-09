/**
		Set an untyped variable in the block namespace.
		The BlockNameSpace would normally delegate this set to the parent.
		Typed variables are naturally set locally.
		This is used in try/catch block argument. 
	*/
public void setBlockVariable(String name, Object value) throws UtilEvalError {
    super.setVariable(name, value, /*strict?*/
    false, false);
}