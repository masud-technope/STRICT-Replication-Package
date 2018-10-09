/**
		@return the enclosing class body namespace or null if not in a class.
	*/
static NameSpace getClassNameSpace(NameSpace thisNameSpace) {
    //if ( thisNameSpace.classInstance != null )
    if (thisNameSpace.isClass)
        return thisNameSpace;
    if (thisNameSpace.isMethod && thisNameSpace.getParent() != null && //&& thisNameSpace.getParent().classInstance != null
    thisNameSpace.getParent().isClass)
        return thisNameSpace.getParent();
    return null;
}