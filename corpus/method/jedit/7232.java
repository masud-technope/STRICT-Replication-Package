//}}}
//{{{ backspace() method
/**
	 * Deletes the character before the caret, or the selection, if one is
	 * active.
	 * @since jEdit 2.7pre2
	 */
public void backspace() {
    delete(false);
}