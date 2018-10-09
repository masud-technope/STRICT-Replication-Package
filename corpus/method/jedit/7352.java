//{{{ paintValidLine() method
@Override
public void paintValidLine(Graphics2D gfx, int screenLine, int physicalLine, int start, int end, int y) {
    // minimise access$ methods
    TextArea textArea = TextAreaPainter.this.textArea;
    JEditBuffer buffer = textArea.getBuffer();
    //{{{ Paint line highlight and collapsed fold highlight
    boolean collapsedFold = physicalLine < buffer.getLineCount() - 1 && buffer.isFoldStart(physicalLine) && !textArea.displayManager.isLineVisible(physicalLine + 1);
    SyntaxStyle foldLineStyle = null;
    if (collapsedFold) {
        int level = buffer.getFoldLevel(physicalLine + 1);
        if (buffer.getFoldHandler() instanceof IndentFoldHandler)
            level = Math.max(1, level / buffer.getIndentSize());
        if (level > 3)
            level = 0;
        foldLineStyle = TextAreaPainter.this.foldLineStyle[level];
    }
    int caret = textArea.getCaretPosition();
    boolean paintLineHighlight = shouldPaintLineHighlight(caret, start, end);
    Color bgColor;
    if (paintLineHighlight)
        bgColor = lineHighlightColor;
    else if (collapsedFold) {
        bgColor = foldLineStyle.getBackgroundColor();
        if (bgColor == null)
            bgColor = getBackground();
    } else
        bgColor = getBackground();
    if (paintLineHighlight || collapsedFold) {
        gfx.setColor(bgColor);
        gfx.fillRect(0, y, getWidth(), getLineHeight());
    //}}}
    }
    //{{{ Paint token backgrounds
    ChunkCache.LineInfo lineInfo = textArea.chunkCache.getLineInfo(screenLine);
    if (lineInfo.chunks != null) {
        float baseLine = y + getLineHeight() - (fm.getLeading() + 1) - fm.getDescent();
        Chunk.paintChunkBackgrounds(lineInfo.chunks, gfx, textArea.getHorizontalOffset(), baseLine, getLineHeight());
    //}}}
    }
//}}}
}