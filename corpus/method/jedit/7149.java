/**
	 * Moves the caret to the start of the next word.
	 * @since jEdit 4.1pre5
	 */
public void goToNextWord(boolean select, boolean eatWhitespace) {
    if (buffer.isLoading())
        return;
    int lineStart = getLineStartOffset(caretLine);
    int newCaret = caret - lineStart;
    String lineText = getLineText(caretLine);
    if (newCaret == lineText.length()) {
        int nextLine = displayManager.getNextVisibleLine(caretLine);
        if (nextLine == -1) {
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
            return;
        }
        newCaret = getLineStartOffset(nextLine);
    } else {
        String noWordSep = buffer.getStringProperty("noWordSep");
        boolean camelCasedWords = buffer.getBooleanProperty("camelCasedWords");
        newCaret = TextUtilities.findWordEnd(lineText, newCaret + 1, noWordSep, true, camelCasedWords, eatWhitespace);
        newCaret += lineStart;
    }
    if (select)
        extendSelection(caret, newCaret);
    else if (!multi)
        selectNone();
    moveCaretPosition(newCaret);
}