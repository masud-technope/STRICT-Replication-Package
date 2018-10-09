//}}}
//{{{ setHorizontalOffset() method
/**
	 * Sets the horizontal offset of drawn lines. This can be used to
	 * implement horizontal scrolling.
	 * @param horizontalOffset offset The new horizontal offset
	 */
public void setHorizontalOffset(int horizontalOffset) {
    if (horizontalOffset > 0)
        horizontalOffset = 0;
    if (horizontalOffset == this.horizontalOffset)
        return;
    this.horizontalOffset = horizontalOffset;
    painter.repaint();
    fireScrollEvent(false);
}