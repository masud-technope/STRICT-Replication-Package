/**
		Get the actual BlockNameSpace 'this' reference.
		<p/>
		Normally a 'this' reference to a BlockNameSpace (e.g. if () { } )
		resolves to the parent namespace (e.g. the namespace containing the
		"if" statement).  However when code inside the BlockNameSpace needs to
		resolve things relative to 'this' we must use the actual block's 'this'
		reference.  Name.java is smart enough to handle this using
		getBlockThis().
		@see #getThis( Interpreter )
    This getBlockThis( Interpreter declaringInterpreter ) 
	{
		return super.getThis( declaringInterpreter );
	}
*/
//
// Begin methods which simply delegate to our parent (enclosing scope) 
//
/**
		This method recurses to find the nearest non-BlockNameSpace parent.

	public NameSpace getParent() 
	{
		NameSpace parent = super.getParent();
		if ( parent instanceof BlockNameSpace )
			return parent.getParent();
		else
			return parent;
	}
*/
/** do we need this? */
private NameSpace getNonBlockParent() {
    NameSpace parent = super.getParent();
    if (parent instanceof BlockNameSpace)
        return ((BlockNameSpace) parent).getNonBlockParent();
    else
        return parent;
}