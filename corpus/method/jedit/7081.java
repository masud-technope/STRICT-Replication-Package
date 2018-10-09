//}}}
//}}}
//{{{ Text editing
//{{{ lineComment() method
/**
	 * Prepends each line of the selection with the line comment string.
	 * @since jEdit 3.2pre1
	 */
public void lineComment() {
    if (!buffer.isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    String comment = buffer.getContextSensitiveProperty(caret, "lineComment");
    if (comment == null || comment.length() == 0) {
        rangeLineComment();
        return;
    }
    comment += ' ';
    buffer.beginCompoundEdit();
    int[] lines = getSelectedLines();
    try {
        for (int line : lines) {
            String text = getLineText(line);
            buffer.insert(getLineStartOffset(line) + StandardUtilities.getLeadingWhiteSpace(text), comment);
        }
    } finally {
        buffer.endCompoundEdit();
    }
    selectNone();
}