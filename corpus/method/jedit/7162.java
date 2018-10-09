//}}}
//{{{ rangeLineComment() method
/**
	 * This method will surround each selected line with a range comment.
	 * This is used when calling line comment if the edit mode doesn't have
	 * a line comment property
	 * @since jEdit 4.3pre10
	 */
private void rangeLineComment() {
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
        int[] lines = getSelectedLines();
        for (int line : lines) {
            String text = getLineText(line);
            if (text.trim().length() == 0)
                continue;
            buffer.insert(getLineEndOffset(line) - 1, commentEnd);
            buffer.insert(getLineStartOffset(line) + StandardUtilities.getLeadingWhiteSpace(text), commentStart);
        }
    } finally {
        buffer.endCompoundEdit();
    }
}