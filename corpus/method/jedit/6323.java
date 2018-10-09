public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == searchCurrentBuffer)
        hyperSearch.setSelected(false);
    else if (source == searchSelection || source == searchAllBuffers || source == searchDirectory)
        hyperSearch.setSelected(true);
    save(true);
    updateEnabled();
}