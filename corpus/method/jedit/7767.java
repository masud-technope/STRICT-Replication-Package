public int findEndOfSentence() {
    int caret = textArea.getCaretPosition();
    for (; ; ) {
        if (atEndOfBuffer(caret))
            break;
        char ch = charAt(caret);
        if (ch == '.' && Character.isWhitespace(charAt(caret + 1))) {
            caret++;
            break;
        }
        caret++;
    }
    return caret;
}