//}}}
//{{{ getExpansion() method
public String getExpansion() {
    StringBuilder buf = new StringBuilder();
    String beforeCaretText = beforeCaret.getText();
    String afterCaretText = afterCaret.getText();
    for (int i = 0; i < beforeCaretText.length(); i++) {
        char ch = beforeCaretText.charAt(i);
        switch(ch) {
            case '\n':
                buf.append("\\n");
                break;
            case '\t':
                buf.append("\\t");
                break;
            case '\\':
                buf.append("\\\\");
                break;
            default:
                buf.append(ch);
                break;
        }
    }
    if (afterCaretText.length() != 0) {
        buf.append("\\|");
        for (int i = 0; i < afterCaretText.length(); i++) {
            char ch = afterCaretText.charAt(i);
            switch(ch) {
                case '\n':
                    buf.append("\\n");
                    break;
                case '\t':
                    buf.append("\\t");
                    break;
                case '\\':
                    buf.append("\\\\");
                    break;
                default:
                    buf.append(ch);
                    break;
            }
        }
    }
    return buf.toString();
}