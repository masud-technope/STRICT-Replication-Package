// {{{ paintFoldEnd()
public void paintFoldEnd(Gutter gutter, Graphics2D gfx, int screenLine, int physicalLine, int y, int lineHeight, JEditBuffer buffer) {
    gfx.setColor(gutter.getFoldColor());
    int _y = y + lineHeight / 2;
    int _x = 5;
    gfx.drawLine(_x, y, _x, _y + 3);
    gfx.drawLine(_x, _y + 3, _x + 4, _y + 3);
    boolean nested = (physicalLine < buffer.getLineCount() - 1 && buffer.getFoldLevel(physicalLine + 1) > 0);
    if (nested)
        gfx.drawLine(_x, y + 4, _x, y + lineHeight - 1);
}