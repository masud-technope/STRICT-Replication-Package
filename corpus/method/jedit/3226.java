//}}}
//{{{ layoutContainer() method
public void layoutContainer(Container parent) {
    Dimension size = parent.getSize();
    Dimension _topToolbars = new Dimension(0, 0);
    Dimension _bottomToolbars = new Dimension(0, 0);
    int topButtonHeight = -1;
    int bottomButtonHeight = -1;
    int leftButtonWidth = -1;
    int rightButtonWidth = -1;
    Dimension _top = top.getPreferredSize();
    Dimension _left = left.getPreferredSize();
    Dimension _bottom = bottom.getPreferredSize();
    Dimension _right = right.getPreferredSize();
    int topHeight = _top.height;
    int bottomHeight = _bottom.height;
    int leftWidth = _left.width;
    int rightWidth = _right.width;
    boolean topEmpty = ((Container) topButtons).getComponentCount() <= 2;
    boolean leftEmpty = ((Container) leftButtons).getComponentCount() <= 2;
    boolean bottomEmpty = ((Container) bottomButtons).getComponentCount() <= 2;
    boolean rightEmpty = ((Container) rightButtons).getComponentCount() <= 2;
    Dimension closeBoxSize;
    if (((Container) topButtons).getComponentCount() == 0)
        closeBoxSize = new Dimension(0, 0);
    else {
        closeBoxSize = ((Container) topButtons).getComponent(0).getPreferredSize();
    }
    int closeBoxWidth = Math.max(closeBoxSize.width, closeBoxSize.height) + 1;
    if (alternateLayout) {
        //{{{ Lay out independent buttons
        int _width = size.width;
        int padding = (leftEmpty && rightEmpty) ? 0 : closeBoxWidth;
        topButtonHeight = top.getWindowContainer().getWrappedDimension(top.getSize().width - closeBoxWidth * 2);
        topButtons.setBounds(padding, 0, size.width - padding * 2, topButtonHeight);
        bottomButtonHeight = bottom.getWindowContainer().getWrappedDimension(bottom.getSize().width);
        bottomButtons.setBounds(padding, size.height - bottomButtonHeight, size.width - padding * 2, bottomButtonHeight);
        int _height = size.height - topButtonHeight - bottomButtonHeight;
        //}}}
        //{{{ Lay out dependent buttons
        leftButtonWidth = left.getWindowContainer().getWrappedDimension(left.getSize().height);
        leftButtons.setBounds(0, topHeight + topButtonHeight, leftButtonWidth, _height - topHeight - bottomHeight);
        rightButtonWidth = right.getWindowContainer().getWrappedDimension(right.getSize().height);
        rightButtons.setBounds(size.width - rightButtonWidth, topHeight + topButtonHeight, rightButtonWidth, _height - topHeight - bottomHeight);
        //}}}
        int[] dimensions = adjustDockingAreasToFit(size, topHeight, leftWidth, bottomHeight, rightWidth, topButtonHeight, leftButtonWidth, bottomButtonHeight, rightButtonWidth, _topToolbars, _bottomToolbars);
        topHeight = dimensions[0];
        leftWidth = dimensions[1];
        bottomHeight = dimensions[2];
        rightWidth = dimensions[3];
        //{{{ Lay out docking areas
        top.setBounds(0, topButtonHeight, size.width, topHeight);
        bottom.setBounds(0, size.height - bottomHeight - bottomButtonHeight, size.width, bottomHeight);
        left.setBounds(leftButtonWidth, topButtonHeight + topHeight, leftWidth, _height - topHeight - bottomHeight);
        right.setBounds(_width - rightButtonWidth - rightWidth, topButtonHeight + topHeight, rightWidth, //}}}
        _height - topHeight - //}}}
        bottomHeight);
    } else {
        //{{{ Lay out independent buttons
        int _height = size.height;
        int padding = (topEmpty && bottomEmpty ? 0 : closeBoxWidth);
        leftButtonWidth = left.getWindowContainer().getWrappedDimension(left.getSize().height - closeBoxWidth * 2);
        leftButtons.setBounds(0, padding, leftButtonWidth, _height - padding * 2);
        rightButtonWidth = right.getWindowContainer().getWrappedDimension(right.getSize().height);
        rightButtons.setBounds(size.width - rightButtonWidth, padding, rightButtonWidth, _height - padding * 2);
        int _width = size.width - leftButtonWidth - rightButtonWidth;
        //}}}
        //{{{ Lay out dependent buttons
        topButtonHeight = top.getWindowContainer().getWrappedDimension(top.getSize().width);
        topButtons.setBounds(leftButtonWidth + leftWidth, 0, _width - leftWidth - rightWidth, topButtonHeight);
        bottomButtonHeight = bottom.getWindowContainer().getWrappedDimension(bottom.getSize().width);
        bottomButtons.setBounds(leftButtonWidth + leftWidth, _height - bottomButtonHeight, _width - leftWidth - rightWidth, bottomButtonHeight//}}}
        );
        int[] dimensions = adjustDockingAreasToFit(size, topHeight, leftWidth, bottomHeight, rightWidth, topButtonHeight, leftButtonWidth, bottomButtonHeight, rightButtonWidth, _topToolbars, _bottomToolbars);
        topHeight = dimensions[0];
        leftWidth = dimensions[1];
        bottomHeight = dimensions[2];
        rightWidth = dimensions[3];
        //{{{ Lay out docking areas
        top.setBounds(leftButtonWidth + leftWidth, topButtonHeight, _width - leftWidth - rightWidth, topHeight);
        bottom.setBounds(leftButtonWidth + leftWidth, size.height - bottomHeight - bottomButtonHeight, _width - leftWidth - rightWidth, bottomHeight);
        left.setBounds(leftButtonWidth, 0, leftWidth, _height);
        right.setBounds(size.width - rightWidth - rightButtonWidth, 0, rightWidth, //}}}
        _height);
    }
    //{{{ Position center (edit pane, or split pane)
    if (center != null) {
        center.setBounds(leftButtonWidth + leftWidth, topButtonHeight + topHeight + _topToolbars.height, size.width - leftWidth - rightWidth - leftButtonWidth - rightButtonWidth, size.height - topHeight - topButtonHeight - bottomHeight - bottomButtonHeight - _topToolbars.height - _bottomToolbars.height);
    //}}}
    }
}