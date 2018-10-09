/**
		Set the global namespace for this interpreter.
		<p>

		Note: This is here for completeness.  If you're using this a lot
		it may be an indication that you are doing more work than you have
		to.  For example, caching the interpreter instance rather than the
		namespace should not add a significant overhead.  No state other
		than the debug status is stored in the interpreter.
		<p>

		All features of the namespace can also be accessed using the
		interpreter via eval() and the script variable 'this.namespace'
		(or global.namespace as necessary).
	*/
public void setNameSpace(NameSpace globalNameSpace) {
    this.globalNameSpace = globalNameSpace;
}