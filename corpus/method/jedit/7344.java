@Override
public void paintValidLine(Graphics2D gfx, int screenLine, int physicalLine, int start, int end, int y) {
    ChunkCache.LineInfo lineInfo = textArea.chunkCache.getLineInfo(screenLine);
    Font defaultFont = getFont();
    Color defaultColor = getForeground();
    gfx.setFont(defaultFont);
    gfx.setColor(defaultColor);
    int x = textArea.getHorizontalOffset();
    int originalX = x;
    float baseLine = y + getLineHeight() - (fm.getLeading() + 1) - fm.getDescent();
    if (lineInfo.chunks != null) {
        x += Chunk.paintChunkList(lineInfo.chunks, gfx, textArea.getHorizontalOffset(), baseLine, !Debug.DISABLE_GLYPH_VECTOR);
    }
    JEditBuffer buffer = textArea.getBuffer();
    if (!lineInfo.lastSubregion) {
        gfx.setFont(defaultFont);
        gfx.setColor(eolMarkerColor);
        gfx.drawString(":", Math.max(x, textArea.getHorizontalOffset() + textArea.wrapMargin + textArea.charWidth), baseLine);
        x += textArea.charWidth;
    } else if (physicalLine < buffer.getLineCount() - 1 && buffer.isFoldStart(physicalLine) && !textArea.displayManager.isLineVisible(physicalLine + 1)) {
        int level = buffer.getFoldLevel(physicalLine + 1);
        if (buffer.getFoldHandler() instanceof IndentFoldHandler)
            level = Math.max(1, level / buffer.getIndentSize());
        if (level > 3)
            level = 0;
        SyntaxStyle foldLineStyle = TextAreaPainter.this.foldLineStyle[level];
        Font font = foldLineStyle.getFont();
        gfx.setFont(font);
        gfx.setColor(foldLineStyle.getForegroundColor());
        int nextLine;
        int nextScreenLine = screenLine + 1;
        if (nextScreenLine < textArea.getVisibleLines()) {
            nextLine = textArea.chunkCache.getLineInfo(nextScreenLine).physicalLine;
        } else {
            nextLine = textArea.displayManager.getNextVisibleLine(physicalLine);
        }
        if (nextLine == -1)
            nextLine = textArea.getLineCount();
        int count = nextLine - physicalLine - 1;
        String str = " [" + count + " lines]";
        float width = getStringWidth(str);
        gfx.drawString(str, x, baseLine);
        x += width;
    } else if (eolMarkers) {
        gfx.setFont(defaultFont);
        gfx.setColor(eolMarkerColor);
        gfx.drawString(eolMarkerChar, x, baseLine);
        x += textArea.charWidth;
    }
    lineInfo.width = x - originalX;
}