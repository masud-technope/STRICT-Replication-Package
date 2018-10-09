//{{{ paintScreenLineRange() method
/**
	 * Paints a range of screen lines. The default implementation calls
	 * {@link #paintValidLine(Graphics2D,int,int,int,int,int)} and
	 * {@link #paintInvalidLine(Graphics2D,int,int)}.
	 * @param gfx A graphics context
	 * @param firstLine The first screen line
	 * @param lastLine The last screen line
	 * @param physicalLines The list of physical line numbers. Entries are
	 * -1 if the screen line is out of range.
	 * @param start An array of screen line start offsets.
	 * @param end An array of screen line end offsets
	 * @param y The y co-ordinate
	 * @param lineHeight The line height
	 * @since jEdit 4.2pre2
	 */
public void paintScreenLineRange(Graphics2D gfx, int firstLine, int lastLine, int[] physicalLines, int[] start, int[] end, int y, int lineHeight) {
    for (int i = 0; i < physicalLines.length; i++) {
        int screenLine = i + firstLine;
        if (physicalLines[i] == -1)
            paintInvalidLine(gfx, screenLine, y);
        else {
            paintValidLine(gfx, screenLine, physicalLines[i], start[i], end[i], y);
        }
        y += lineHeight;
    }
}