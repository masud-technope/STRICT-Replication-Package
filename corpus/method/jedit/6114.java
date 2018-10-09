// Boyer-Moore helper methods
//{{{ generateSkipArray() method
/*
	 *  the 'skip' array is used to determine for each index in the
	 *  hashed alphabet how many characters can be skipped if
	 *  a mismatch occurs on a characater hashing to that index.
	 */
private int[] generateSkipArray(boolean reverse) {
    // initialize the skip array to all zeros
    int[] skip = new int[256];
    // leave the table cleanly-initialized for an empty pattern
    if (pattern.length == 0)
        return skip;
    int pos = 0;
    do {
        skip[getSkipIndex(pattern[reverse ? pattern_end - pos : pos])] = pos;
    } while (++pos < pattern.length);
    return skip;
}