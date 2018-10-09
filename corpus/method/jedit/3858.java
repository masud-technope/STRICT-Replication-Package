//{{{ preferredLayoutSizeTB() method
private Dimension preferredLayoutSizeTB(int dimension, Insets insets, Component[] comp, Dimension dim) {
    int height = dimension - insets.bottom;
    int colWidth = Math.max(dim.width, closeBox.getPreferredSize().height);
    int y = (colWidth << 1) + insets.top;
    Dimension returnValue = new Dimension(colWidth + insets.left + insets.right, 0);
    for (int i = 2; i < comp.length; i++) {
        int btnHeight = comp[i].getPreferredSize().height;
        if (btnHeight + y > height) {
            returnValue.width += colWidth;
            y = insets.top;
        }
        y += btnHeight;
    }
    return returnValue;
//}}}
}