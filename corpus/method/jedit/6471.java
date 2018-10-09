//}}}
//{{{ lookup() method
/**
	 * Looks up a key.
	 * @param text The text segment
	 * @param offset The offset of the substring within the text segment
	 * @param length The length of the substring
	 */
public byte lookup(Segment text, int offset, int length) {
    if (length == 0)
        return Token.NULL;
    Keyword k = map[getSegmentMapKey(text, offset, length)];
    while (k != null) {
        if (length != k.keyword.length) {
            k = k.next;
            continue;
        }
        if (SyntaxUtilities.regionMatches(ignoreCase, text, offset, k.keyword))
            return k.id;
        k = k.next;
    }
    return Token.NULL;
}