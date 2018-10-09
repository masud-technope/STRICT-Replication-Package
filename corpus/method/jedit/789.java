@Override
public void itemStateChanged(ItemEvent e) {
    if (isProcessingEvent)
        return;
    if (e.getStateChange() != ItemEvent.SELECTED)
        return;
    isProcessingEvent = true;
    resetLater();
    filterField.setEditable(e.getItem() instanceof GlobVFSFileFilter);
    updateFilterEnabled();
    String path = pathField.getText();
    if (path != null)
        setDirectory(path);
    browserView.focusOnFileView();
}