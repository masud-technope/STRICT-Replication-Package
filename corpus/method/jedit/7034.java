/**
	 * Deletes the word in front of the caret.
	 *
.	 * @param eatWhitespace If true, will eat whitespace
	 * @since jEdit 4.2pre5
	 */
public void deleteWord(boolean eatWhitespace) {
    if (!buffer.isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    if (getSelectionCount() != 0) {
        setSelectedText("");
        return;
    }
    int lineStart = getLineStartOffset(caretLine);
    int _caret = caret - lineStart;
    String lineText = getLineText(caretLine);
    if (_caret == lineText.length()) {
        if (lineStart + _caret == buffer.getLength()) {
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
            return;
        }
        _caret++;
    } else {
        String noWordSep = buffer.getStringProperty("noWordSep");
        boolean camelCasedWords = buffer.getBooleanProperty("camelCasedWords");
        _caret = TextUtilities.findWordEnd(lineText, _caret + 1, noWordSep, true, camelCasedWords, eatWhitespace);
    }
    buffer.remove(caret, (_caret + lineStart) - caret);
}