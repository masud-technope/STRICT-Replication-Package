//{{{ findCompletion() method
/**
	 * Return the index of a file whose name matches the given string,
	 * in a case-insensitive manner. Exact matches are preferred,
	 * then same length with different cases, then first found.
	 * @param files The list of files
	 * @param start The start index, inclusive
	 * @param end The end index, exclusive
	 * @param str The string to match
	 * @param dirsOnly Only match directories?
	 * @since jEdit 4.3pre3
	 */
public static int findCompletion(VFSFile[] files, int start, int end, String str, boolean dirsOnly) {
    boolean strIsAbsolute = MiscUtilities.isAbsolutePath(str);
    int strLen = str.length();
    int iPotentialMatch = -1;
    boolean potentialMatchGTStr = false;
    for (int i = start; i < end; i++) {
        VFSFile file = files[i];
        String matchAgainst = (strIsAbsolute ? file.getPath() : file.getName());
        if (dirsOnly && file.getType() == FILE) {
            continue;
        } else /* try exact match first */
        if (matchAgainst.equals(str)) {
            return i;
        } else if (matchAgainst.regionMatches(true, 0, str, 0, strLen)) {
            // not found yet or not exact length yet and has exact length
            if (iPotentialMatch == -1 || (potentialMatchGTStr && (matchAgainst.length() == strLen))) {
                iPotentialMatch = i;
                potentialMatchGTStr = matchAgainst.length() > strLen;
            }
        }
    }
    return iPotentialMatch;
}