//}}}
//{{{ goToBuffer() method
/**
	 * If this buffer is open in one of the view's edit panes, sets focus
	 * to that edit pane. Otherwise, opens the buffer in the currently
	 * active edit pane.
	 * @param buffer The buffer
	 * @return the current edit pane
	 * @since jEdit 4.2pre1
	 */
public EditPane goToBuffer(Buffer buffer) {
    return showBuffer(buffer, true);
}