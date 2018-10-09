public int findBeginningOfSentence() {
    int caret = textArea.getCaretPosition() - 1;
    if (charAt(caret) == '.')
        caret--;
    for (; ; ) {
        if (caret <= 0)
            break;
        char ch = charAt(caret);
        if (ch == '.') {
            if (Character.isWhitespace(charAt(caret + 1))) {
                caret++;
                break;
            }
        } else if (Character.isUpperCase(ch)) {
            caret--;
            if (caret <= 0)
                break;
            if (Character.isWhitespace(charAt(caret)))
                break;
        }
        caret--;
    }
    return caret;
}