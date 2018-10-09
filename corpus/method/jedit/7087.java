//}}}
//{{{ rangeComment() method
/**
	 * Adds comment start and end strings to the beginning and end of the
	 * selection.
	 * @since jEdit 3.2pre1
	 */
public void rangeComment() {
    String commentStart = buffer.getContextSensitiveProperty(caret, "commentStart");
    String commentEnd = buffer.getContextSensitiveProperty(caret, "commentEnd");
    if (!buffer.isEditable() || commentStart == null || commentEnd == null || commentStart.length() == 0 || commentEnd.length() == 0) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    commentStart += ' ';
    commentEnd = ' ' + commentEnd;
    try {
        buffer.beginCompoundEdit();
        Selection[] selection = getSelection();
        if (selection.length == 0) {
            int oldCaret = caret;
            buffer.insert(caret, commentStart);
            buffer.insert(caret, commentEnd);
            setCaretPosition(oldCaret + commentStart.length());
        }
        for (Selection s : selection) {
            if (s instanceof Selection.Range) {
                buffer.insert(s.start, commentStart);
                buffer.insert(s.end, commentEnd);
            } else if (s instanceof Selection.Rect) {
                Selection.Rect rect = (Selection.Rect) s;
                int start = rect.getStartColumn(buffer);
                int end = rect.getEndColumn(buffer);
                for (int j = s.startLine; j <= s.endLine; j++) {
                    buffer.insertAtColumn(j, end, commentEnd);
                    buffer.insertAtColumn(j, start, commentStart);
                }
            }
        }
        selectNone();
    } finally {
        buffer.endCompoundEdit();
    }
}