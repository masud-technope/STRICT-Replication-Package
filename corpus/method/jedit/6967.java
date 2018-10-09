// }}}
// {{{ paintFoldMiddle()
public void paintFoldMiddle(Gutter gutter, Graphics2D gfx, int screenLine, int physicalLine, int y, int lineHeight, JEditBuffer buffer) {
    gfx.setColor(gutter.getFoldColor());
    gfx.drawLine(5, y, 5, y + lineHeight - 1);
}