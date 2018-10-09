//}}}
//{{{ _setHorizontalOffset() method
/**
	 * Sets the horizontal offset of drawn lines. This method will
	 * check if the offset do not go too far after the last character
	 * @param horizontalOffset offset The new horizontal offset
	 */
private void _setHorizontalOffset(int horizontalOffset) {
    if (horizontalOffset > 0)
        horizontalOffset = 0;
    if (horizontalOffset == this.horizontalOffset)
        return;
    // Scrolling with trackpad or other device should be kept inside bounds
    int min = Math.min(-(maxHorizontalScrollWidth + charWidth - painter.getWidth()), 0);
    if (horizontalOffset < min)
        horizontalOffset = min;
    setHorizontalOffset(horizontalOffset);
}