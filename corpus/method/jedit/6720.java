//}}}
//{{{ notifyScreenLineChanges() method
/**
	 * FirstLine or ScrollLineCount changed
	 * Update ScrollBar, etc.
	 */
void notifyScreenLineChanges() {
    if (Debug.SCROLL_DEBUG)
        Log.log(Log.DEBUG, this, "notifyScreenLineChanges()");
    // Otherwise, the screen line calculation will be incorrect.
    assert textArea.getDisplayManager() == this;
    try {
        if (firstLine.isCallReset())
            firstLine.reset();
        else if (firstLine.isCallChanged())
            firstLine.changed();
        if (scrollLineCount.isCallReset()) {
            scrollLineCount.reset();
            //FIXME: Why here?
            firstLine.ensurePhysicalLineIsVisible();
        } else if (scrollLineCount.isCallChanged())
            scrollLineCount.changed();
        if (firstLine.isCallChanged() || scrollLineCount.isCallReset() || scrollLineCount.isCallChanged()) {
            textArea.updateScrollBar();
            textArea.recalculateLastPhysicalLine();
        }
    } finally {
        firstLine.resetCallState();
        scrollLineCount.resetCallState();
    }
}