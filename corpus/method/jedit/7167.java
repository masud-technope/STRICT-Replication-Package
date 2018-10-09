//}}}
//{{{ goToPrevWord() method
/**
	 * Moves the caret to the start of the previous word.
	 * @param select true if you want to extend selection
	 * @since jEdit 2.7pre2
	 */
public void goToPrevWord(boolean select) {
    goToPrevWord(select, false);
}