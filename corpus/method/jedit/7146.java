//}}}
//{{{ goToPrevWord() method
/**
	 * Moves the caret to the start of the previous word.
	 * @param eatWhitespace If true, will eat whitespace
	 * @since jEdit 4.1pre5
	 */
public void goToPrevWord(boolean select, boolean eatWhitespace) {
    goToPrevWord(select, eatWhitespace, false);
}