/**
		This constructor is used in class generation.
	*/
 Variable(String name, String typeDescriptor, Object value, Modifiers modifiers) throws UtilEvalError {
    this(name, (Class) null, /*type*/
    value, modifiers);
    this.typeDescriptor = typeDescriptor;
}