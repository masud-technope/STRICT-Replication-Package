public int eatNonAlphanums() {
    boolean eat = true;
    while (eat) {
        char ch = charAtCaret();
        if (ch == '\n') {
            textArea.goToNextLine(false);
            textArea.goToStartOfLine(false);
        } else {
            if (Character.isLetterOrDigit(ch))
                eat = false;
            else
                textArea.goToNextCharacter(false);
        }
    }
    return textArea.getCaretPosition();
}