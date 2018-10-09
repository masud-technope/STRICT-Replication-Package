public void focusGained(FocusEvent e) {
    contentTextArea.getDocument().addDocumentListener(documentHandler);
}