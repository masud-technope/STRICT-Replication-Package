// }}}
// {{{ paintFoldStart()
public void paintFoldStart(Gutter gutter, Graphics2D gfx, int screenLine, int physicalLine, boolean nextLineVisible, int y, int lineHeight, JEditBuffer buffer) {
    int _y = y + lineHeight / 2;
    int _x = 5;
    gfx.setColor(gutter.getFoldColor());
    paintFoldShape(gfx, _y - 4, _y + 4);
    gfx.drawLine(_x - 2, _y, _x + 2, _y);
    boolean nested = (buffer.getFoldLevel(physicalLine) > 0);
    if (nested)
        gfx.drawLine(_x, y, _x, _y - 5);
    if (nextLineVisible)
        gfx.drawLine(_x, _y + 5, _x, y + lineHeight - 1);
    else {
        gfx.drawLine(_x, _y - 2, _x, _y + 2);
        if (nested)
            gfx.drawLine(_x, _y + 4, _x, y + lineHeight - 1);
    }
}