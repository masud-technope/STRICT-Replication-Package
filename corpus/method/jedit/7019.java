//}}}
//{{{ backspaceWord() method
/**
	 * Deletes the word before the caret.
	 * @param eatWhitespace If true, will eat whitespace
	 * @param eatOnlyAfterWord Eat only whitespace after a word,
	 * in effect this goes to actual word starts even if eating
	 * @since jEdit 4.4pre1
	 */
public void backspaceWord(boolean eatWhitespace, boolean eatOnlyAfterWord) {
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
    if (_caret == 0) {
        if (lineStart == 0) {
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
            return;
        }
        _caret--;
    } else {
        String noWordSep = buffer.getStringProperty("noWordSep");
        boolean camelCasedWords = buffer.getBooleanProperty("camelCasedWords");
        _caret = TextUtilities.findWordStart(lineText, _caret - 1, noWordSep, true, camelCasedWords, eatWhitespace, eatOnlyAfterWord);
    }
    buffer.remove(_caret + lineStart, caret - (_caret + lineStart));
}