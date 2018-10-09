//{{{ preferredLayoutSize() method
public Dimension preferredLayoutSize(Container parent) {
    Insets insets = ((JComponent) parent).getBorder().getBorderInsets(parent);
    Component[] comp = parent.getComponents();
    if (comp.length <= 2) {
        // nothing 'cept close box
        return new Dimension(0, 0);
    }
    Dimension dim = comp[2].getPreferredSize();
    if (position.equals(DockableWindowManagerImpl.TOP) || position.equals(DockableWindowManagerImpl.BOTTOM)) {
        int width = parent.getWidth() - insets.right;
        Dimension returnValue = preferredLayoutSizeLR(insets, comp, dim, width);
        return returnValue;
    } else {
        Dimension returnValue = preferredLayoutSizeTB(parent.getHeight(), insets, comp, dim);
        return returnValue;
    }
//}}}
}