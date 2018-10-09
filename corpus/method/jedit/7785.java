public char charAtCaret() {
    int caret = textArea.getCaretPosition();
    return (atEndOfBuffer() ? '\0' : buffer.getText(caret, 1).charAt(0));
}