//}}}
//{{{ highlightString()
/**
	 * Creates an HTML presentation of a given string, where selected substrings
	 * are highlighted with a given syntax style tag.
	 *
	 * @param s The (non-HTML) string to highlight. 
	 * @param styleTag The HTML string representing the highlight style.
	 * @param ranges The indices of the substrings to highlight, in pairs: The start
	 *               index of a substring followed by the end index of the substring.
	 * @return The HTML representation of the string with highlighted substrings. 
	 */
public static String highlightString(String s, String styleTag, List<Integer> ranges) {
    StringBuilder sb = new StringBuilder("<html><style>.highlight {");
    sb.append(styleTag);
    sb.append("}</style><body>");
    int lastIndex = 0;
    for (int i = 0; i < ranges.size(); i += 2) {
        int rangeStart = ranges.get(i);
        int rangeEnd = ranges.get(i + 1);
        appendString2html(sb, s.substring(lastIndex, rangeStart));
        sb.append("<span class=\"highlight\">");
        appendString2html(sb, s.substring(rangeStart, rangeEnd));
        sb.append("</span>");
        lastIndex = rangeEnd;
    }
    appendString2html(sb, s.substring(lastIndex));
    sb.append("</body></html>");
    return sb.toString();
}