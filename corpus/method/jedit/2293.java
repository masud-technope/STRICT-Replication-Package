/**
		Climb the class and interface inheritence graph of the type and collect
		all methods matching the specified name and criterion.  If publicOnly
		is true then only public methods in *public* classes or interfaces will
		be returned.  In the normal (non-accessible) case this addresses the
		problem that arises when a package private class or private inner class
		implements a public interface or derives from a public type.
	 	<p/>

	 	This method primarily just delegates to gatherMethodsRecursive()
	 	@see #gatherMethodsRecursive(
			Class, String, int, boolean, java.util.Vector)
	*/
static Method[] getCandidateMethods(Class baseClass, String methodName, int numArgs, boolean publicOnly) {
    Vector candidates = gatherMethodsRecursive(baseClass, methodName, numArgs, publicOnly, /*candidates*/
    null);
    // return the methods in an array
    Method[] ma = new Method[candidates.size()];
    candidates.copyInto(ma);
    return ma;
}