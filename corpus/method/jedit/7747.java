//{{{ charsToEntities() method
/**
	 * Converts &lt;, &gt;, &amp; in the string to their HTML entity
	 * equivalents.
	 *
	 * <p>If <code>xml11</code> is true, then character entities
	 * are used to convert illegal XML characters (mainly ASCII
	 * control characters).</p>
	 *
	 * @param str The string
	 * @param xml11 Whether to allow XML 1.1 constructs.
	 */
public static String charsToEntities(String str, boolean xml11) {
    StringBuilder buf = new StringBuilder(str.length());
    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        // See: http://www.w3.org/International/questions/qa-controls
        if (((0x00 <= ch && ch <= 0x1F) || (0x7F <= ch && ch <= 0x9F)) && ch != '\r' && ch != '\n' && ch != '\t') {
            if (xml11 && ch != 0x00) {
                buf.append("&#").append((int) ch).append(';');
            } else {
                // The character is illegal.
                // But put a PI instead, to make it
                // recoverable in certain apps.
                buf.append("<?illegal-xml-character ").append((int) ch).append("?>");
            }
            continue;
        }
        switch(ch) {
            case '<':
                buf.append("&lt;");
                break;
            case '>':
                buf.append("&gt;");
                break;
            case '&':
                buf.append("&amp;");
                break;
            default:
                buf.append(ch);
                break;
        }
    }
    return buf.toString();
}