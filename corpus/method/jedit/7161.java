//}}}
//{{{ goToPrevPage() method
/**
	 * Moves the caret to the previous screenful.
	 * @param select true if you want to extend selection
	 * @since jEdit 2.7pre2
	 */
public void goToPrevPage(boolean select) {
    scrollToCaret(electricScroll > 0);
    int magic = getMagicCaretPosition();
    if (caretLine < displayManager.getFirstVisibleLine()) {
        caretLine = displayManager.getNextVisibleLine(caretLine);
    }
    int newCaret;
    if (getFirstLine() == 0) {
        int firstVisibleLine = displayManager.getFirstVisibleLine();
        newCaret = getLineStartOffset(firstVisibleLine);
    } else {
        int caretScreenLine = getScreenLineOfOffset(caret);
        scrollUpPage();
        newCaret = xToScreenLineOffset(caretScreenLine, magic, true);
    }
    if (select)
        extendSelection(caret, newCaret);
    else if (!multi)
        selectNone();
    moveCaretPosition(newCaret, false);
    setMagicCaretPosition(magic);
}