public int eatWhitespace() {
    boolean eat = true;
    while (eat) {
        char ch = charAtCaret();
        if (ch == '\n') {
            textArea.goToNextLine(false);
            textArea.goToStartOfLine(false);
        } else if (Character.isWhitespace(ch)) {
            textArea.goToNextCharacter(false);
        } else {
            eat = false;
        }
    }
    return textArea.getCaretPosition();
}