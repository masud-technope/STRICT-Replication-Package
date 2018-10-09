/**
		Accumulate all methods, optionally including non-public methods,
	 	class and interface, in the inheritence tree of baseClass.

		This method is analogous to Class getMethods() which returns all public
		methods in the inheritence tree.

		In the normal (non-accessible) case this also addresses the problem
		that arises when a package private class or private inner class
		implements a public interface or derives from a public type.  In other
		words, sometimes we'll find public methods that we can't use directly
		and we have to find the same public method in a parent class or
		interface.

		@return the candidate methods vector
	*/
private static Vector gatherMethodsRecursive(Class baseClass, String methodName, int numArgs, boolean publicOnly, Vector candidates) {
    if (candidates == null)
        candidates = new Vector();
    // (This addresses secure environments)
    if (publicOnly) {
        if (isPublic(baseClass))
            addCandidates(baseClass.getMethods(), methodName, numArgs, publicOnly, candidates);
    } else
        addCandidates(baseClass.getDeclaredMethods(), methodName, numArgs, publicOnly, candidates);
    // Does the class or interface implement interfaces?
    Class[] intfs = baseClass.getInterfaces();
    for (int i = 0; i < intfs.length; i++) gatherMethodsRecursive(intfs[i], methodName, numArgs, publicOnly, candidates);
    // Do we have a superclass? (interfaces don't, etc.)
    Class superclass = baseClass.getSuperclass();
    if (superclass != null)
        gatherMethodsRecursive(superclass, methodName, numArgs, publicOnly, candidates);
    return candidates;
}