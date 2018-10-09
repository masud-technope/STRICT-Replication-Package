//}}}
//{{{ goToMatchingBracket() method
/**
	 * Moves the caret to the bracket matching the one before the caret.
	 * @since jEdit 2.7pre3
	 */
public void goToMatchingBracket() {
    if (getLineLength(caretLine) != 0) {
        int dot = caret - getLineStartOffset(caretLine);
        int bracket = TextUtilities.findMatchingBracket(buffer, caretLine, Math.max(0, dot - 1));
        if (bracket != -1) {
            selectNone();
            moveCaretPosition(bracket + 1, false);
            return;
        }
    }
    javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
}