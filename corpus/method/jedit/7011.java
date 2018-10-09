/**
	 * Deletes the word before the caret.
	 * @param eatWhitespace If true, will eat whitespace
	 * @since jEdit 4.2pre5
	 */
public void backspaceWord(boolean eatWhitespace) {
    backspaceWord(eatWhitespace, false);
}