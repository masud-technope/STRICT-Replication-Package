//}}}
//{{{ layoutContainer() method
public void layoutContainer(Container parent) {
    Dimension size = parent.getSize();
    Insets insets = getInsets(parent);
    int itop = insets.top;
    int ileft = insets.left;
    int ibottom = insets.bottom;
    int iright = insets.right;
    int leftWidth = getLeftPreferredWidth();
    int rightWidth = getRightPreferredWidth();
    int topHeight = getTopPreferredHeight();
    int bottomHeight = getBottomPreferredHeight();
    int centerWidth = Math.max(0, size.width - leftWidth - rightWidth - ileft - iright);
    int centerHeight = Math.max(0, size.height - topHeight - bottomHeight - itop - ibottom);
    if (left != null) {
        left.setBounds(ileft, itop + topHeight, leftWidth, centerHeight);
    }
    if (center != null) {
        center.setBounds(ileft + leftWidth, itop + topHeight, centerWidth, centerHeight);
    }
    if (right != null) {
        right.setBounds(ileft + leftWidth + centerWidth, itop + topHeight, rightWidth, centerHeight);
    }
    if (bottom != null) {
        bottom.setBounds(ileft + leftWidth, itop + topHeight + centerHeight, centerWidth, bottomHeight);
    }
    if (top != null) {
        top.setBounds(ileft + leftWidth, itop, centerWidth, topHeight);
    }
    if (topLeft != null) {
        topLeft.setBounds(ileft, itop, leftWidth, topHeight);
    }
    if (topRight != null) {
        topRight.setBounds(ileft + leftWidth + centerWidth, itop, rightWidth, topHeight);
    }
    if (bottomLeft != null) {
        bottomLeft.setBounds(ileft, itop + topHeight + centerHeight, leftWidth, bottomHeight);
    }
    if (bottomRight != null) {
        bottomRight.setBounds(ileft + leftWidth + centerWidth, itop + topHeight + centerHeight, rightWidth, bottomHeight);
    }
}