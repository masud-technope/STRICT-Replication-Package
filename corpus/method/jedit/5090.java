//}}}
//}}}
//{{{ Text methods
//{{{ escapesToChars() method
/**
	 * Converts "\n" and "\t" escapes in the specified string to
	 * newlines and tabs.
	 * @param str The string
	 * @since jEdit 2.3pre1
	 */
public static String escapesToChars(String str) {
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        switch(c) {
            case '\\':
                if (i == str.length() - 1) {
                    buf.append('\\');
                    break;
                }
                c = str.charAt(++i);
                switch(c) {
                    case 'n':
                        buf.append('\n');
                        break;
                    case 't':
                        buf.append('\t');
                        break;
                    default:
                        buf.append(c);
                        break;
                }
                break;
            default:
                buf.append(c);
        }
    }
    return buf.toString();
}