String shorten(String item) {
    StringBuilder buf = new StringBuilder();
    // with <html> using the HTML engine
    if (item.toLowerCase().startsWith("<html>"))
        buf.append(' ');
    boolean ws = true;
    for (int i = 0; i < item.length(); i++) {
        // Don't make the list items too large
        if (buf.length() == maxItemLength) {
            buf.append("...");
            break;
        }
        char ch = item.charAt(i);
        if (Character.isWhitespace(ch)) {
            if (!ws) {
                buf.append(' ');
                ws = true;
            }
        } else {
            ws = false;
            buf.append(ch);
        }
    }
    if (buf.length() == 0)
        return jEdit.getProperty("paste-from-list.whitespace");
    return buf.toString();
}