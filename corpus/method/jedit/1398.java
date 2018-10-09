/**
		Get the parent Interpreter of this interpreter, if any.
		Currently this relationship implies the following:
			1) Parent and child share a BshClassManager
			2) Children indicate the parent's source file information in error
			reporting.
		When created as part of a source() / eval() the child also shares
		the parent's namespace.  But that is not necessary in general.
	*/
public Interpreter getParent() {
    return parent;
}