private static void _paste(TextArea textArea, boolean vertical, String selection, JEditBuffer buffer) {
    try {
        buffer.beginCompoundEdit();
        /* vertical paste */
        if (vertical && textArea.getSelectionCount() == 0) {
            int caret = textArea.getCaretPosition();
            int caretLine = textArea.getCaretLine();
            Selection.Rect rect = new Selection.Rect(caretLine, caret, caretLine, caret);
            textArea.setSelectedText(rect, selection);
            caretLine = textArea.getCaretLine();
            if (caretLine != textArea.getLineCount() - 1) {
                int startColumn = rect.getStartColumn(buffer);
                int offset = buffer.getOffsetOfVirtualColumn(caretLine + 1, startColumn, null);
                if (offset == -1) {
                    buffer.insertAtColumn(caretLine + 1, startColumn, "");
                    textArea.setCaretPosition(buffer.getLineEndOffset(caretLine + 1) - 1);
                } else {
                    textArea.setCaretPosition(buffer.getLineStartOffset(caretLine + 1) + offset);
                }
            }
        } else /* Regular paste */
        {
            textArea.replaceSelection(selection);
        }
    } finally {
        buffer.endCompoundEdit();
    }
    HistoryModel.getModel("clipboard").addItem(selection);
}