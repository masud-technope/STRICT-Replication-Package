//}}}
//{{{ updateScrollBar() method
/**
	 * Updates the state of the scroll bars. This should be called
	 * if the number of lines in the buffer changes, or when the
	 * size of the text are changes.
	 */
void updateScrollBar() {
    if (buffer == null)
        return;
    if (Debug.SCROLL_DEBUG)
        Log.log(Log.DEBUG, this, "updateScrollBar(), slc=" + displayManager.getScrollLineCount());
    if (vertical != null && visibleLines != 0) {
        if (Debug.SCROLL_DEBUG)
            Log.log(Log.DEBUG, this, "Vertical ok");
        final int lineCount = displayManager.getScrollLineCount();
        final int firstLine = getFirstLine();
        final int visible = visibleLines - (lastLinePartial ? 1 : 0);
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                vertical.setValues(firstLine, visible, 0, lineCount);
                vertical.setUnitIncrement(2);
                vertical.setBlockIncrement(visible);
            }
        };
        ThreadUtilities.runInDispatchThread(runnable);
    }
}