//}}}
//{{{ globToRE() method
/**
	 * Converts a Unix-style glob to a regular expression.<p>
	 *
	 * ? becomes ., * becomes .*, {aa,bb} becomes (aa|bb).
	 * @param glob The glob pattern
	 * @since jEdit 4.3pre7
	 */
public static String globToRE(String glob) {
    if (glob.startsWith("(re)")) {
        return glob.substring(4);
    }
    final Object NEG = new Object();
    final Object GROUP = new Object();
    Stack<Object> state = new Stack<Object>();
    StringBuilder buf = new StringBuilder();
    boolean backslash = false;
    for (int i = 0; i < glob.length(); i++) {
        char c = glob.charAt(i);
        if (backslash) {
            buf.append('\\');
            buf.append(c);
            backslash = false;
            continue;
        }
        switch(c) {
            case '\\':
                backslash = true;
                break;
            case '?':
                buf.append('.');
                break;
            case '.':
            case '+':
            case '(':
            case ')':
                buf.append('\\');
                buf.append(c);
                break;
            case '*':
                buf.append(".*");
                break;
            case '|':
                if (backslash)
                    buf.append("\\|");
                else
                    buf.append('|');
                break;
            case '{':
                buf.append('(');
                if (i + 1 != glob.length() && glob.charAt(i + 1) == '!') {
                    buf.append('?');
                    state.push(NEG);
                } else
                    state.push(GROUP);
                break;
            case ',':
                if (!state.isEmpty() && state.peek() == GROUP)
                    buf.append('|');
                else
                    buf.append(',');
                break;
            case '}':
                if (!state.isEmpty()) {
                    buf.append(')');
                    if (state.pop() == NEG)
                        buf.append(".*");
                } else
                    buf.append('}');
                break;
            default:
                buf.append(c);
        }
    }
    return buf.toString();
}