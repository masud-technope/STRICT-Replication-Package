//{{{ preferredLayoutSizeLR() method
private Dimension preferredLayoutSizeLR(Insets insets, Component[] comp, Dimension dim, int width) {
    int rowHeight = Math.max(dim.height, closeBox.getPreferredSize().width);
    int x = (rowHeight << 1) + insets.left;
    Dimension returnValue = new Dimension(0, rowHeight + insets.top + insets.bottom);
    for (int i = 2; i < comp.length; i++) {
        int btnWidth = comp[i].getPreferredSize().width;
        if (btnWidth + x > width) {
            returnValue.height += rowHeight;
            x = insets.left;
        }
        x += btnWidth;
    }
    return returnValue;
//}}}
}