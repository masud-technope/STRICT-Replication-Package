//}}}
//{{{ showWaitCursor() method
/**
	 * Shows the wait cursor. This method and
	 * {@link #hideWaitCursor()} are implemented using a reference
	 * count of requests for wait cursors, so that nested calls work
	 * correctly; however, you should be careful to use these methods in
	 * tandem.<p>
	 *
	 * To ensure that {@link #hideWaitCursor()} is always called
	 * after a {@link #showWaitCursor()}, use a
	 * <code>try</code>/<code>finally</code> block, like this:
	 * <pre>try
	 *{
	 *    view.showWaitCursor();
	 *    // ...
	 *}
	 *finally
	 *{
	 *    view.hideWaitCursor();
	 *}</pre>
	 */
public synchronized void showWaitCursor() {
    if (waitCount++ == 0) {
        Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
        setCursor(cursor);
        visit(new SetCursorVisitor(cursor));
    }
}