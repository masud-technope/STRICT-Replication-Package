//}}}
//{{{ goToNextWord() methods
/**
	 * Moves the caret to the start of the next word.
	 * Note that if the "view.eatWhitespace" boolean propery is false,
	 * this method moves the caret to the end of the current word instead.
	 * @param select true if you want to extend selection
	 * @since jEdit 2.7pre2
	 */
public void goToNextWord(boolean select) {
    goToNextWord(select, false);
}