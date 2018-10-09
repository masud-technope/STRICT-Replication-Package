//}}}
//{{{ goToLastVisibleLine() method
/**
	 * Moves the caret to the last visible line.
	 * @param select true if you want to extend selection
	 * @since jEdit 2.7pre2
	 */
public void goToLastVisibleLine(boolean select) {
    int lastVisible;
    if (getFirstLine() + visibleLines >= displayManager.getScrollLineCount()) {
        lastVisible = getLineEndOffset(displayManager.getLastVisibleLine()) - 1;
    } else {
        lastVisible = visibleLines - electricScroll - 1;
        if (lastLinePartial)
            lastVisible--;
        if (lastVisible < 0)
            lastVisible = 0;
        lastVisible = getScreenLineEndOffset(lastVisible) - 1;
        if (lastVisible == -1) {
            lastVisible = getLineEndOffset(displayManager.getLastVisibleLine()) - 1;
        }
    }
    if (select)
        extendSelection(caret, lastVisible);
    else if (!multi)
        selectNone();
    moveCaretPosition(lastVisible);
}