//}}}
//{{{ hideWaitCursor() method
/**
	 * Hides the wait cursor.
	 */
public synchronized void hideWaitCursor() {
    if (waitCount > 0)
        waitCount--;
    if (waitCount == 0) {
        // still needed even though glass pane
        // has a wait cursor
        Cursor cursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
        setCursor(cursor);
        visit(new SetCursorVisitor(cursor));
    }
}