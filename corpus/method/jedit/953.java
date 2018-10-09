/**
		Get a 'this' reference is our parent's 'this' for the object closure.
		e.g. Normally a 'this' reference to a BlockNameSpace (e.g. if () { } )
		resolves to the parent namespace (e.g. the namespace containing the
		"if" statement). 
		@see #getBlockThis( Interpreter )
	*/
This getThis(Interpreter declaringInterpreter) {
    return getNonBlockParent().getThis(declaringInterpreter);
}