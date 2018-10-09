public void update() {
    Selection selection = textArea.getSelectionAtOffset(textArea.getCaretPosition());
    if (selection == null) {
        selectionLength.setText("0");
    } else {
        int selectionEnd = selection.getEnd();
        int selectionStart = selection.getStart();
        int len;
        if (selection instanceof Selection.Rect) {
            int startLine = selection.getStartLine();
            int endLine = selection.getEndLine();
            JEditTextArea textArea = view.getTextArea();
            int startLineOffset = textArea.getLineStartOffset(startLine);
            int endLineOffset = textArea.getLineStartOffset(endLine);
            int lines = endLine - startLine + 1;
            int columns = (selectionEnd - endLineOffset) - (selectionStart - startLineOffset);
            len = lines * columns;
        } else
            len = selectionEnd - selectionStart;
        selectionLength.setText(Integer.toString(len));
    }
}