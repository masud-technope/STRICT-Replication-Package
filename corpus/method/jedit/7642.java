/**
	 * Escapes the specified characters in the specified string.
	 * @param str The string
	 * @param toEscape Any characters that require escaping
	 * @since jEdit 4.3pre15
	 */
public static String charsToEscapes(String str, String toEscape) {
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (toEscape.indexOf(c) != -1) {
            if (c == '\n')
                buf.append("\\n");
            else if (c == '\t')
                buf.append("\\t");
            else {
                buf.append('\\');
                buf.append(c);
            }
        } else
            buf.append(c);
    }
    return buf.toString();
}