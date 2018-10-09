//}}}
//{{{ adjustDockingAreasToFit() method
private int[] adjustDockingAreasToFit(Dimension size, int topHeight, int leftWidth, int bottomHeight, int rightWidth, int topButtonHeight, int leftButtonWidth, int bottomButtonHeight, int rightButtonWidth, Dimension _topToolbars, Dimension _bottomToolbars) {
    int maxTopHeight = size.height - bottomHeight - topButtonHeight - bottomButtonHeight - _topToolbars.height - _bottomToolbars.height;
    topHeight = Math.min(Math.max(0, maxTopHeight), topHeight);
    leftWidth = Math.min(Math.max(0, size.width - leftButtonWidth - rightButtonWidth - rightWidth), leftWidth);
    int maxBottomHeight = size.height - topHeight - topButtonHeight - bottomButtonHeight - _topToolbars.height - _bottomToolbars.height;
    bottomHeight = Math.min(Math.max(0, maxBottomHeight), bottomHeight);
    rightWidth = Math.min(Math.max(0, size.width - leftButtonWidth - rightButtonWidth - leftWidth), rightWidth);
    top.getWindowContainer().setDimension(topHeight);
    left.getWindowContainer().setDimension(leftWidth);
    bottom.getWindowContainer().setDimension(bottomHeight);
    right.getWindowContainer().setDimension(rightWidth);
    return new int[] { topHeight, leftWidth, bottomHeight, rightWidth };
}