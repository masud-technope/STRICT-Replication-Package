//}}}
//{{{ showBuffer() method
/**
	 * If this buffer is open in one of the view's edit panes, activates
	 * that edit pane. Otherwise, opens the buffer in the currently
	 * active edit pane. But the focus is not moved.
	 * @param buffer The buffer to show
	 * @return the current edit pane
	 * @since jEdit 4.3pre13
	 */
public EditPane showBuffer(Buffer buffer) {
    return showBuffer(buffer, false);
}