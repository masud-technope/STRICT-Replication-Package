public void setExpansion(String expansion) {
    if (expansion == null) {
        beforeCaret.setText(null);
        afterCaret.setText(null);
        return;
    }
    String beforeCaretText = null;
    String afterCaretText = null;
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < expansion.length(); i++) {
        char ch = expansion.charAt(i);
        if (ch == '\\' && i != expansion.length() - 1) {
            ch = expansion.charAt(++i);
            switch(ch) {
                case 't':
                    buf.append('\t');
                    break;
                case 'n':
                    buf.append('\n');
                    break;
                case '|':
                    beforeCaretText = buf.toString();
                    buf.setLength(0);
                    break;
                default:
                    buf.append(ch);
                    break;
            }
        } else
            buf.append(ch);
    }
    if (beforeCaretText == null)
        beforeCaretText = buf.toString();
    else
        afterCaretText = buf.toString();
    beforeCaret.setText(beforeCaretText);
    afterCaret.setText(afterCaretText);
}