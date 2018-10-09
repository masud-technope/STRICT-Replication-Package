public void setClipboard(Selection selection) {
    TextArea textArea = jEdit.getActiveView().getTextArea();
    setClipboard(textArea.getSelectedText(selection));
}