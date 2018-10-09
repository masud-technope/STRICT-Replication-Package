public boolean atEndOfBuffer() {
    TextArea textArea = jEdit.getActiveView().getTextArea();
    return atEndOfBuffer(textArea.getCaretPosition());
}