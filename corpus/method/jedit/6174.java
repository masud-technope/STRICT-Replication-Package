public void run() {
    Selection[] s = getSelection();
    if (s == null)
        return;
    JEditTextArea textArea = editPane.getTextArea();
    if (textArea.isMultipleSelectionEnabled())
        textArea.addToSelection(s);
    else
        textArea.setSelection(s);
    textArea.moveCaretPosition(occur.endPos.getOffset());
}