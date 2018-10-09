/**
	 * Sets the vertical scroll bar position.
	 * @param physFirstLine The first physical line to display
	 * @param skew A local screen line delta
	 * @since jEdit 4.2pre1
	 */
public void setFirstPhysicalLine(int physFirstLine, int skew) {
    if (Debug.SCROLL_DEBUG) {
        Log.log(Log.DEBUG, this, "setFirstPhysicalLine(" + physFirstLine + ',' + skew + ')');
    }
    int amount = physFirstLine - displayManager.firstLine.getPhysicalLine();
    displayManager.setFirstPhysicalLine(amount, skew);
    repaint();
    fireScrollEvent(true);
}