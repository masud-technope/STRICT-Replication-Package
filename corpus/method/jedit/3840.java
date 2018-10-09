//{{{ paintBorder() method
public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    updateColors();
    if (color1 == null || color2 == null || color3 == null)
        return;
    if (position.equals(DockableWindowManagerImpl.BOTTOM))
        paintHorizBorder(g, x, y, width);
    else if (position.equals(DockableWindowManagerImpl.RIGHT))
        paintVertBorder(g, x, y, height);
    else if (position.equals(DockableWindowManagerImpl.TOP)) {
        paintHorizBorder(g, x, y + height - SPLITTER_WIDTH, width);
    } else if (position.equals(DockableWindowManagerImpl.LEFT)) {
        paintVertBorder(g, x + width - SPLITTER_WIDTH, y, height);
    }
//}}}
}