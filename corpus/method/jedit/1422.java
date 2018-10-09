/**
		Get the class manager associated with this interpreter
		(the BshClassManager of this interpreter's global namespace).
		This is primarily a convenience method.
	*/
public BshClassManager getClassManager() {
    return getNameSpace().getClassManager();
}