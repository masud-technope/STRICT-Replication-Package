//{{{ charsToEscapes() methods
/**
	 * Escapes newlines, tabs, backslashes, and quotes in the specified
	 * string.
	 * @param str The string
	 * @since jEdit 4.3pre15
	 */
public static String charsToEscapes(String str) {
    return charsToEscapes(str, "\n\t\\\"'");
}