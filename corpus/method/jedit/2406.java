/**
		@param value may be null if this 
	*/
 Variable(String name, Class type, Object value, Modifiers modifiers) throws UtilEvalError {
    this.name = name;
    this.type = type;
    this.modifiers = modifiers;
    setValue(value, DECLARATION);
}