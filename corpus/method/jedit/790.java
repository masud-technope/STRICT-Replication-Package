@Override
public void actionPerformed(ActionEvent evt) {
    if (isProcessingEvent)
        return;
    Object source = evt.getSource();
    if (source == pathField || source == filterCheckbox) {
        isProcessingEvent = true;
        resetLater();
        updateFilterEnabled();
        String p = pathField.getText();
        if (p != null)
            setDirectory(p);
        browserView.focusOnFileView();
    } else if (source == filterField.getEditor()) {
        // force the editor to refresh.
        filterField.getEditor().setItem(filterField.getEditor().getItem());
    } else // returns some ComboBoxUI
    if (source == filterEditor) {
        // force the editor to refresh.
        filterEditor.setItem(filterEditor.getItem());
        filterField.setSelectedItem(filterEditor.getItem());
        // ### ugly:
        // itemStateChanged does not seem to get fired
        itemStateChanged(new ItemEvent(filterField, ItemEvent.ITEM_STATE_CHANGED, filterEditor.getItem(), ItemEvent.SELECTED));
    }
}