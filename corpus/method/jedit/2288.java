/**
        Implement JLS 15.11.2
		Return the index of the most specific arguments match or -1 if no
		match is found.
		This method is used by both methods and constructors (which
	 	unfortunately don't share a common interface for signature info).

	 @return the index of the most specific candidate

	 */
/*
	 Note: Two methods which are equally specific should not be allowed by
	 the Java compiler.  In this case BeanShell currently chooses the first
	 one it finds.  We could add a test for this case here (I believe) by
	 adding another isSignatureAssignable() in the other direction between
	 the target and "best" match.  If the assignment works both ways then
	 neither is more specific and they are ambiguous.  I'll leave this test
	 out for now because I'm not sure how much another test would impact
	 performance.  Method selection is now cached at a high level, so a few
	 friendly extraneous tests shouldn't be a problem.
	*/
static int findMostSpecificSignature(Class[] idealMatch, Class[][] candidates) {
    for (int round = Types.FIRST_ROUND_ASSIGNABLE; round <= Types.LAST_ROUND_ASSIGNABLE; round++) {
        Class[] bestMatch = null;
        int bestMatchIndex = -1;
        for (int i = 0; i < candidates.length; i++) {
            Class[] targetMatch = candidates[i];
            // the new best match.
            if (Types.isSignatureAssignable(idealMatch, targetMatch, round) && ((bestMatch == null) || Types.isSignatureAssignable(targetMatch, bestMatch, Types.JAVA_BASE_ASSIGNABLE))) {
                bestMatch = targetMatch;
                bestMatchIndex = i;
            }
        }
        if (bestMatch != null)
            return bestMatchIndex;
    }
    return -1;
}