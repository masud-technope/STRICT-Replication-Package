//}}}
//{{{ getText() methods
/**
	 * Returns the specified substring of the buffer.
	 * @param start The start offset
	 * @param len The length of the substring
	 * @return The substring
	 */
public final String getText(int start, int len) {
    return buffer.getText(start, len);
}