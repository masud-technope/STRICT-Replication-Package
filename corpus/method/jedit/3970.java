//}}}
//{{{ ok() method
public void ok() {
    int startLine;
    int endLine;
    try {
        startLine = Integer.parseInt(startField.getText()) - 1;
        endLine = Integer.parseInt(endField.getText()) - 1;
    } catch (NumberFormatException nf) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    Buffer buffer = view.getBuffer();
    if (startLine < 0 || endLine >= buffer.getLineCount() || startLine > endLine) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    JEditTextArea textArea = view.getTextArea();
    Selection s = new Selection.Range(buffer.getLineStartOffset(startLine), buffer.getLineEndOffset(endLine) - 1);
    if (textArea.isMultipleSelectionEnabled())
        textArea.addToSelection(s);
    else
        textArea.setSelection(s);
    textArea.moveCaretPosition(buffer.getLineEndOffset(endLine) - 1);
    dispose();
}