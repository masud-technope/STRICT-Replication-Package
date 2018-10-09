//}}}
//{{{ preferredLayoutSize() method
public Dimension preferredLayoutSize(Container parent) {
    Dimension prefSize = new Dimension(0, 0);
    Dimension _top = top.getPreferredSize();
    Dimension _left = left.getPreferredSize();
    Dimension _bottom = bottom.getPreferredSize();
    Dimension _right = right.getPreferredSize();
    Dimension _topButtons = topButtons.getPreferredSize();
    Dimension _leftButtons = leftButtons.getPreferredSize();
    Dimension _bottomButtons = bottomButtons.getPreferredSize();
    Dimension _rightButtons = rightButtons.getPreferredSize();
    Dimension _center = (center == null ? new Dimension(0, 0) : center.getPreferredSize());
    Dimension _topToolbars = new Dimension(0, 0);
    Dimension _bottomToolbars = new Dimension(0, 0);
    prefSize.height = _top.height + _bottom.height + _center.height + _topButtons.height + _bottomButtons.height + _topToolbars.height + _bottomToolbars.height;
    prefSize.width = _left.width + _right.width + Math.max(_center.width, Math.max(_topToolbars.width, _bottomToolbars.width)) + _leftButtons.width + _rightButtons.width;
    return prefSize;
}