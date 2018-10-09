//{{{ regionMatches() method
/**
	 * Checks if a subregion of a <code>Segment</code> is equal to a
	 * character array.
	 * @param ignoreCase True if case should be ignored, false otherwise
	 * @param text The segment
	 * @param offset The offset into the segment
	 * @param match The character array to match
	 * @return true if the subregion of the segment was
	 * equals to the character array
	 * @since jEdit 4.2pre1
	 */
public static boolean regionMatches(boolean ignoreCase, Segment text, int offset, char[] match) {
    int length = offset + match.length;
    if (length > text.offset + text.count)
        return false;
    char[] textArray = text.array;
    for (int i = offset, j = 0; i < length; i++, j++) {
        char c1 = textArray[i];
        char c2 = match[j];
        if (ignoreCase) {
            c1 = Character.toUpperCase(c1);
            c2 = Character.toUpperCase(c2);
        }
        if (c1 != c2)
            return false;
    }
    return true;
}