//}}}
//{{{ goToNextPage() method
/**
	 * Moves the caret to the next screenful.
	 * @param select true if you want to extend selection
	 * @since jEdit 2.7pre2.
	 */
public void goToNextPage(boolean select) {
    scrollToCaret(electricScroll > 0);
    int magic = getMagicCaretPosition();
    if (caretLine < displayManager.getFirstVisibleLine()) {
        caretLine = displayManager.getNextVisibleLine(caretLine);
    }
    int newCaret;
    if (getFirstLine() + getVisibleLines() >= displayManager.getScrollLineCount()) {
        int lastVisibleLine = displayManager.getLastVisibleLine();
        newCaret = getLineEndOffset(lastVisibleLine) - 1;
    } else {
        int caretScreenLine = getScreenLineOfOffset(caret);
        scrollDownPage();
        newCaret = xToScreenLineOffset(caretScreenLine, magic, true);
    }
    if (select)
        extendSelection(caret, newCaret);
    else if (!multi)
        selectNone();
    moveCaretPosition(newCaret, false);
    setMagicCaretPosition(magic);
}