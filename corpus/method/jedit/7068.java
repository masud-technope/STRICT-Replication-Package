//}}}
//{{{ collapseFold() methods
/**
	 * Like {@link DisplayManager#collapseFold(int)}, but
	 * also moves the caret to the first line of the fold.
	 * @since jEdit 4.0pre3
	 */
public void collapseFold() {
    collapseFold(caretLine);
}