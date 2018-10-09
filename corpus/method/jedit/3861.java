//{{{ getWrappedDimension() method
/**
		 * Returns the width or height of wrapped rows or columns.
		 */
int getWrappedDimension(JComponent parent, int dimension) {
    Insets insets = parent.getBorder().getBorderInsets(parent);
    Component[] comp = parent.getComponents();
    if (comp.length <= 2)
        return 0;
    Dimension dim = comp[2].getPreferredSize();
    if (position.equals(DockableWindowManagerImpl.TOP) || position.equals(DockableWindowManagerImpl.BOTTOM)) {
        int width = dimension - insets.right;
        Dimension returnValue = preferredLayoutSizeLR(insets, comp, dim, width);
        return returnValue.height;
    } else {
        Dimension returnValue = preferredLayoutSizeTB(dimension, insets, comp, dim);
        return returnValue.width;
    }
//}}}
}