public void focusLost(FocusEvent e) {
    contentTextArea.getDocument().removeDocumentListener(documentHandler);
}