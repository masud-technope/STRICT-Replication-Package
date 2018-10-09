//{{{ paintChunkList() method
/**
	 * Paints a chunk list.
	 * @param chunks The chunk list
	 * @param gfx The graphics context
	 * @param x The x co-ordinate
	 * @param y The y co-ordinate
	 * @param glyphVector true if we want to use glyphVector, false if we
	 * want to use drawString
	 * @return The width of the painted text
	 * @since jEdit 4.2pre1
	 */
public static float paintChunkList(Chunk chunks, Graphics2D gfx, float x, float y, boolean glyphVector) {
    Rectangle clipRect = gfx.getClipBounds();
    float _x = 0.0f;
    while (chunks != null) {
        // only paint visible chunks
        if (x + _x + chunks.width > clipRect.x && x + _x < clipRect.x + clipRect.width) {
            // Useful for debugging purposes
            if (Debug.CHUNK_PAINT_DEBUG) {
                gfx.draw(new Rectangle2D.Float(x + _x, y - 10, chunks.width, 10));
            }
            if (chunks.isAccessible() && chunks.glyphs != null) {
                gfx.setFont(chunks.style.getFont());
                gfx.setColor(chunks.style.getForegroundColor());
                if (glyphVector)
                    chunks.drawGlyphs(gfx, x + _x, y);
                else if (chunks.str != null) {
                    gfx.drawString(chunks.str, x + _x, y);
                }
            }
        }
        _x += chunks.width;
        chunks = (Chunk) chunks.next;
    }
    return _x;
}