/**
	 * Paints the beginning of a fold in the gutter.
	 * @param gutter The gutter in which the fold is drawn.
	 * @param gfx The graphics object to use for the painting.
	 * @param screenLine The index of the line on the screen (e.g. 5th from top).
	 * @param physicalLine The index of the line in the buffer.
	 * @param nextLineVisible Whether the next buffer line is visible on screen.
	 * @param y The y coordinate of the top of the line on the screen.
	 * @param lineHeight The line height in pixels.
	 * @param buffer The buffer to which the line belongs.
	 */
void paintFoldStart(Gutter gutter, Graphics2D gfx, int screenLine, int physicalLine, boolean nextLineVisible, int y, int lineHeight, JEditBuffer buffer);