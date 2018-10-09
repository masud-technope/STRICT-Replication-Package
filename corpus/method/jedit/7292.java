//}}}
//{{{ finishCaretUpdate() method
/**
	 * the collapsing of scrolling/event firing inside compound edits
	 * greatly speeds up replace-all.
	 */
private void finishCaretUpdate(int oldCaretLine, int scrollMode, boolean fireCaretEvent) {
    queuedFireCaretEvent |= fireCaretEvent;
    queuedScrollMode = Math.max(scrollMode, queuedScrollMode);
    if (queuedCaretUpdate)
        return;
    this.oldCaretLine = oldCaretLine;
    queuedCaretUpdate = true;
    if (!buffer.isTransactionInProgress())
        _finishCaretUpdate();
/* otherwise DisplayManager.BufferChangeHandler calls */
}