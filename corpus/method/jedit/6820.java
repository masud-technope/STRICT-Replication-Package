//}}}
//{{{ setHighlightInterval() method
/**
	 * Sets the number of lines between highlighted line numbers. Any value
	 * less than or equal to one will result in highlighting being disabled.
	 * @param interval The number of lines between highlighted line numbers
	 */
public void setHighlightInterval(int interval) {
    if (interval <= 1)
        interval = 0;
    this.interval = interval;
    repaint();
}