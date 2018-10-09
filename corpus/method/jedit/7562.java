//}}}
//{{{ appendString2html
/**
	 * Appends a given non-HTML string to an HTML string, translating character
	 * entities to the appropriate HTML form.
	 * 
	 * @param sb The HTML string to which the non-HTML string is appended.
	 * @param s The non-HTML string to append.
	 */
public static void appendString2html(StringBuilder sb, String s) {
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        String r;
        switch(c) {
            case '"':
                r = "&quot;";
                break;
            // case '\'': r = "&apos;"; break;
            case '&':
                r = "&amp;";
                break;
            case '<':
                r = "&lt;";
                break;
            case '>':
                r = "&gt;";
                break;
            case ' ':
                // Maintain amount of whitespace in line
                r = "&nbsp;";
                break;
            default:
                r = String.valueOf(c);
                break;
        }
        sb.append(r);
    }
}