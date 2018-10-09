/**
     * This implementation returns a new Insets instance where the top and left are 1,
     * the bottom and right fields are the border width + 1.
     * @param c the component for which this border insets value applies
     * @return a new Insets object initialized as stated above.
     */
public Insets getBorderInsets(Component c) {
    return new Insets(1, 1, _width + 1, _width + 1);
}