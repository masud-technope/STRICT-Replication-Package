//}}}
//{{{ goToBufferEnd() method
/**
	 * Moves the caret to the end of the buffer.
	 * @param select true if you want to extend selection
	 * @since jEdit 4.0pre3
	 */
public void goToBufferEnd(boolean select) {
    int end = buffer.getLineEndOffset(displayManager.getLastVisibleLine()) - 1;
    if (select)
        extendSelection(caret, end);
    else if (!multi)
        selectNone();
    moveCaretPosition(end);
}