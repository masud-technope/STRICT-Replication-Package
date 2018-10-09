public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == cancelButton)
        System.exit(0);
    else if (source == prevButton) {
        currentPage--;
        pageChanged();
    } else if (source == nextButton) {
        if (currentPage == pages.length - 1)
            System.exit(0);
        else {
            currentPage++;
            pageChanged();
        }
    }
}