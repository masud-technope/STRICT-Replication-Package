//}}}
//}}}
//{{{ Painting
//{{{ invalidateScreenLineRange() method
/**
	 * Marks a range of screen lines as needing a repaint.
	 * @param start The first line
	 * @param end The last line
	 * @since jEdit 4.0pre4
	 */
public void invalidateScreenLineRange(int start, int end) {
    if (buffer.isLoading())
        return;
    if (start > end) {
        int tmp = end;
        end = start;
        start = tmp;
    }
    if (chunkCache.needFullRepaint())
        end = visibleLines;
    int y = start * painter.getLineHeight();
    int height = (end - start + 1) * painter.getLineHeight();
    painter.repaint(0, y, painter.getWidth(), height);
    gutter.repaint(0, y, gutter.getWidth(), height);
}