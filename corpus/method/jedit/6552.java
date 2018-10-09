//}}}
//{{{ substitute() method
/**
	 * Perform substitution references in <code>end</code> to the matched groups in
	 * <code>match</code>. In particular, "$1" is replaced with the first match group in
	 * <code>match</code>, $2 is replaced with the second, all the way up to "$9". Moreover,
	 * if group <code>i</code> matched a single bracket character, then "~i" is replaced with
	 * the complementary bracket.
	 * @param match the <code>Matcher</code> produced by matching the "start" regex
	 * @param end the pattern to substitute in to
	 * @param escape if true, then escape matched text before inserting into <code>end</code>, so that
	 * 	the result can be interpreted as a regex pattern.
	 * @return the substituted pattern
	 */
private static char[] substitute(Matcher match, char[] end, boolean escape) {
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < end.length; i++) {
        char ch = end[i];
        if (ch == '$' || ch == '~') {
            if (i == end.length - 1)
                buf.append(ch);
            else {
                char digit = end[i + 1];
                if (!Character.isDigit(digit))
                    buf.append(ch);
                else if (ch == '$') {
                    String text = match.group(digit - '0');
                    if (escape)
                        text = TextUtilities.escapeText(text);
                    buf.append(text);
                    i++;
                } else {
                    String s = match.group(digit - '0');
                    if (s.length() == 1) {
                        char b = TextUtilities.getComplementaryBracket(s.charAt(0), null);
                        if (b == '\0')
                            b = s.charAt(0);
                        buf.append(b);
                    } else
                        buf.append(ch);
                    i++;
                }
            }
        } else
            buf.append(ch);
    }
    char[] returnValue = new char[buf.length()];
    buf.getChars(0, buf.length(), returnValue, 0);
    return returnValue;
}