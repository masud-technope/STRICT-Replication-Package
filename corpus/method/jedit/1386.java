/**
	*/
void setVariable(String name, Object value, boolean strictJava, boolean recurse) throws UtilEvalError {
    super.setVariable(name, value, strictJava, recurse);
    putExternalMap(name, value);
}