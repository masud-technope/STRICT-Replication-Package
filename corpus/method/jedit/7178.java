//}}}
//{{{ goToFirstVisibleLine() method
/**
	 * Moves the caret to the first visible line.
	 * @param select true if you want to extend selection
	 * @since jEdit 2.7pre2
	 */
public void goToFirstVisibleLine(boolean select) {
    int firstVisibleLine = getFirstLine() == 0 ? 0 : electricScroll;
    int firstVisible = getScreenLineStartOffset(firstVisibleLine);
    if (firstVisible == -1) {
        firstVisible = getLineStartOffset(displayManager.getFirstVisibleLine());
    }
    if (select)
        extendSelection(caret, firstVisible);
    else if (!multi)
        selectNone();
    moveCaretPosition(firstVisible);
}