//}}}
//{{{ paintChunkBackgrounds() method
/**
	 * Paints the background highlights of a chunk list.
	 * @param chunks The chunk list
	 * @param gfx The graphics context
	 * @param x The x co-ordinate
	 * @param y The y co-ordinate
	 * @return The width of the painted backgrounds
	 * @since jEdit 4.2pre1
	 */
public static float paintChunkBackgrounds(Chunk chunks, Graphics2D gfx, float x, float y, float lineHeight) {
    Rectangle clipRect = gfx.getClipBounds();
    float _x = 0.0f;
    FontMetrics forBackground = gfx.getFontMetrics();
    int ascent = forBackground.getAscent();
    float height = lineHeight;
    while (chunks != null) {
        // only paint visible chunks
        if (x + _x + chunks.width > clipRect.x && x + _x < clipRect.x + clipRect.width) {
            if (chunks.isAccessible()) {
                //{{{ Paint token background color if necessary
                Color bgColor = chunks.background;
                if (bgColor != null) {
                    gfx.setColor(bgColor);
                    gfx.fill(new Rectangle2D.Float(x + _x, y - ascent, _x + chunks.width - _x, height));
                //}}}
                }
            }
        }
        _x += chunks.width;
        chunks = (Chunk) chunks.next;
    }
    return _x;
}