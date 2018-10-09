//{{{ goToMatchingBracket() method
/**
	 * Moves the caret to the bracket matching the one before the caret.
	 * Also sends PositionChanging if it goes somewhere.
	 * @since jEdit 4.3pre18
	 */
public void goToMatchingBracket() {
    if (getLineLength(caretLine) != 0) {
        int dot = caret - getLineStartOffset(caretLine);
        int bracket = TextUtilities.findMatchingBracket(buffer, caretLine, Math.max(0, dot - 1));
        if (bracket != -1) {
            EditBus.send(new PositionChanging(this));
            selectNone();
            moveCaretPosition(bracket + 1, false);
            return;
        }
    }
    javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
}