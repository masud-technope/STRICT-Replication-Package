//}}}
//{{{ truncateWhiteSpace() method
public static String truncateWhiteSpace(int len, int tabSize, String indentStr) {
    StringBuilder buf = new StringBuilder();
    int indent = 0;
    for (int i = 0; indent < len && i < indentStr.length(); i++) {
        char c = indentStr.charAt(i);
        if (c == ' ') {
            indent++;
            buf.append(c);
        } else if (c == '\t') {
            int withTab = indent + tabSize - (indent % tabSize);
            if (withTab > len) {
                for (; indent < len; indent++) buf.append(' ');
            } else {
                indent = withTab;
                buf.append(c);
            }
        }
    }
    return buf.toString();
}