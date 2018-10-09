//}}}
//{{{ goToPrevWord() method
/**
	 * Moves the caret to the start of the previous word.
	 * @param eatWhitespace If true, will eat whitespace
	 * @param eatOnlyAfterWord Eat only whitespace after a word,
	 * in effect this goes to actual word starts even if eating
	 * @since jEdit 4.4pre1
	 */
public void goToPrevWord(boolean select, boolean eatWhitespace, boolean eatOnlyAfterWord) {
    if (buffer.isLoading())
        return;
    int lineStart = getLineStartOffset(caretLine);
    int newCaret = caret - lineStart;
    String lineText = getLineText(caretLine);
    if (newCaret == 0) {
        if (lineStart == 0) {
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
            return;
        } else {
            int prevLine = displayManager.getPrevVisibleLine(caretLine);
            if (prevLine == -1) {
                javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
                return;
            }
            newCaret = getLineEndOffset(prevLine) - 1;
        }
    } else {
        String noWordSep = buffer.getStringProperty("noWordSep");
        boolean camelCasedWords = buffer.getBooleanProperty("camelCasedWords");
        newCaret = TextUtilities.findWordStart(lineText, newCaret - 1, noWordSep, true, camelCasedWords, eatWhitespace, eatOnlyAfterWord);
        newCaret += lineStart;
    }
    if (select)
        extendSelection(caret, newCaret);
    else if (!multi)
        selectNone();
    moveCaretPosition(newCaret);
}