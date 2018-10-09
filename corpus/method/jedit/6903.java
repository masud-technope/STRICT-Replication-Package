//{{{ getInsets() method
private Insets getInsets(Component parent) {
    Border border = ((JComponent) parent).getBorder();
    if (border == null)
        return new Insets(0, 0, 0, 0);
    else
        return border.getBorderInsets(parent);
}