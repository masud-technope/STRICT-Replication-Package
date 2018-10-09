//}}}
//{{{ getIndent() method
/**
	 * Returns the length of the string as if it were indented with
	 * spaces instead of tabs.
	 */
private int getIndent(CharSequence line, int tabSize) {
    int cnt = 0;
    for (int i = 0; i < line.length(); i++) {
        if (line.charAt(i) == '\t') {
            cnt += tabSize;
        } else {
            if (!Character.isWhitespace(line.charAt(i))) {
                cnt += (line.length() - i);
                break;
            }
            cnt++;
        }
    }
    return cnt;
}