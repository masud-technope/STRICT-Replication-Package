//}}}
//}}}
//{{{ escapeRegexp() method
/**
	 * Escapes characters with special meaning in a regexp.
	 * @param str the string to escape
	 * @param multiline Should \n be escaped?
	 * @return the string with escaped characters
	 * @since jEdit 4.3pre1
	 */
public static String escapeRegexp(String str, boolean multiline) {
    return StandardUtilities.charsToEscapes(str, "\r\t\\()[]{}$^*+?|." + (multiline ? "" : "\n"));
}