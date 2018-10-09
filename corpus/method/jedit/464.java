public void layoutContainer(Container parent) {
    Dimension size = parent.getSize();
    Dimension captionSize = caption.getPreferredSize();
    caption.setBounds(PADDING, PADDING, captionSize.width, captionSize.height);
    // make all buttons the same size
    Dimension buttonSize = cancelButton.getPreferredSize();
    buttonSize.width = Math.max(buttonSize.width, prevButton.getPreferredSize().width);
    buttonSize.width = Math.max(buttonSize.width, nextButton.getPreferredSize().width);
    // cancel button goes on far left
    cancelButton.setBounds(PADDING, size.height - buttonSize.height - PADDING, buttonSize.width, buttonSize.height);
    // prev and next buttons are on the right
    prevButton.setBounds(size.width - buttonSize.width * 2 - 6 - PADDING, size.height - buttonSize.height - PADDING, buttonSize.width, buttonSize.height);
    nextButton.setBounds(size.width - buttonSize.width - PADDING, size.height - buttonSize.height - PADDING, buttonSize.width, buttonSize.height);
    // calculate size for current page
    Rectangle currentPageBounds = new Rectangle();
    currentPageBounds.x = PADDING;
    currentPageBounds.y = PADDING * 2 + captionSize.height;
    currentPageBounds.width = size.width - currentPageBounds.x - PADDING;
    currentPageBounds.height = size.height - buttonSize.height - currentPageBounds.y - PADDING * 2;
    for (int i = 0; i < pages.length; i++) {
        Component page = pages[i];
        page.setBounds(currentPageBounds);
        page.setVisible(i == currentPage);
    }
}