// }}}
// {{{ paintFoldEnd()
public void paintFoldEnd(Gutter gutter, Graphics2D gfx, int screenLine, int physicalLine, int y, int lineHeight, JEditBuffer buffer) {
    gfx.setColor(gutter.getFoldColor());
    int _y = y + lineHeight / 2;
    gfx.drawLine(4, _y, 4, _y + 3);
    gfx.drawLine(4, _y + 3, 7, _y + 3);
}