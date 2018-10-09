/**
		Find the best match for signature idealMatch.
		It is assumed that the methods array holds only valid candidates
		(e.g. method name and number of args already matched).
		This method currently does not take into account Java 5 covariant
		return types... which I think will require that we find the most
		derived return type of otherwise identical best matches.

	 	@see #findMostSpecificSignature(Class[], Class[][])
		@param methods the set of candidate method which differ only in the
	 		types of their arguments.
	*/
static Method findMostSpecificMethod(Class[] idealMatch, Method[] methods) {
    // copy signatures into array for findMostSpecificMethod()
    Class[][] candidateSigs = new Class[methods.length][];
    for (int i = 0; i < methods.length; i++) candidateSigs[i] = methods[i].getParameterTypes();
    int match = findMostSpecificSignature(idealMatch, candidateSigs);
    return match == -1 ? null : methods[match];
}