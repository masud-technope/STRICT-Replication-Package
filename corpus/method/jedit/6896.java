//}}}
//{{{ preferredLayoutSize() method
public Dimension preferredLayoutSize(Container parent) {
    Dimension dim = new Dimension();
    Insets insets = getInsets(parent);
    dim.width = insets.left + insets.right;
    dim.width += getLeftPreferredWidth();
    dim.width += getCenterPreferredWidth();
    dim.width += getRightPreferredWidth();
    dim.height = insets.top + insets.bottom;
    dim.height += getTopPreferredHeight();
    dim.height += getCenterPreferredHeight();
    dim.height += getBottomPreferredHeight();
    return dim;
}