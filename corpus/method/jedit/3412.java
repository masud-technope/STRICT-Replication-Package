/**
     * Reinitializes the <code>insets</code> parameter with this DropShadowBorder's
     * current Insets.
     * @param c the component for which this border insets value applies
     * @param insets the object to be reinitialized
     * @return the given <code>insets</code> object
     */
public Insets getBorderInsets(Component c, Insets insets) {
    insets.top = 1;
    insets.left = 1;
    insets.bottom = _width + 1;
    insets.right = _width + 1;
    return insets;
}