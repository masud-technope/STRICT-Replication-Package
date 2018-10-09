//}}}
//{{{ goToBufferStart() method
/**
	 * Moves the caret to the beginning of the buffer.
	 * @param select true if you want to extend selection
	 * @since jEdit 4.0pre3
	 */
public void goToBufferStart(boolean select) {
    int start = buffer.getLineStartOffset(displayManager.getFirstVisibleLine());
    if (select)
        extendSelection(caret, start);
    else if (!multi)
        selectNone();
    moveCaretPosition(start);
}