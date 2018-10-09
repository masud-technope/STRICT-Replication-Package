//}}}
//{{{ setFirstLine() method
/**
	 * Sets the vertical scroll bar position
	 *
	 * @param firstLine The scroll bar position
	 */
public void setFirstLine(int firstLine) {
    //{{{ ensure we don't have empty space at the bottom or top, etc
    int max = displayManager.getScrollLineCount() - visibleLines + (lastLinePartial ? 1 : 0);
    if (firstLine > max)
        firstLine = max;
    if (firstLine < 0)
        firstLine = 0;
    //}}}
    int oldFirstLine = getFirstLine();
    if (Debug.SCROLL_DEBUG) {
        Log.log(Log.DEBUG, this, "setFirstLine() from " + oldFirstLine + " to " + firstLine);
    }
    if (firstLine == oldFirstLine)
        return;
    displayManager.setFirstLine(oldFirstLine, firstLine);
    repaint();
    fireScrollEvent(true);
}