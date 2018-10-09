public Dimension preferredLayoutSize(Container parent) {
    Dimension dim = new Dimension();
    Dimension captionSize = caption.getPreferredSize();
    dim.width = captionSize.width;
    for (int i = 0; i < pages.length; i++) {
        Dimension _dim = pages[i].getPreferredSize();
        dim.width = Math.max(_dim.width, dim.width);
        dim.height = Math.max(_dim.height, dim.height);
    }
    dim.width += PADDING * 2;
    dim.height += PADDING * 2;
    dim.height += nextButton.getPreferredSize().height;
    dim.height += captionSize.height;
    return dim;
}