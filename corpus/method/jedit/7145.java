/**
	 * Selects from the bracket at the caret position to the corresponding
	 * bracket.
	 * @since jEdit 4.0pre2
	 */
public void selectToMatchingBracket() {
    selectToMatchingBracket(caret, false);
}