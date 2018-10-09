//}}}
//{{{ createWhiteSpace() method
/**
	 * Creates a string of white space with the specified length.<p>
	 *
	 * To get a whitespace string tuned to the current buffer's
	 * settings, call this method as follows:
	 *
	 * <pre>myWhitespace = MiscUtilities.createWhiteSpace(myLength,
	 *     (buffer.getBooleanProperty("noTabs") ? 0
	 *     : buffer.getTabSize()));</pre>
	 *
	 * @param len The length
	 * @param tabSize The tab size, or 0 if tabs are not to be used
	 * @param start The start offset, for tab alignment
	 */
public static String createWhiteSpace(int len, int tabSize, int start) {
    StringBuilder buf = new StringBuilder();
    if (tabSize == 0) {
        while (len-- > 0) buf.append(' ');
    } else if (len == 1)
        buf.append(' ');
    else {
        int count = (len + start % tabSize) / tabSize;
        if (count != 0)
            len += start;
        while (count-- > 0) buf.append('\t');
        count = len % tabSize;
        while (count-- > 0) buf.append(' ');
    }
    return buf.toString();
}