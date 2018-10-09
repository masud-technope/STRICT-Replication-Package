//}}}
//{{{ formatParagraph() method
/**
	 * Formats the paragraph containing the caret.
	 * @since jEdit 2.7pre2
	 */
public void formatParagraph() throws TextAreaException {
    if (!buffer.isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    if (maxLineLen <= 0) {
        throw new TextAreaException("format-maxlinelen");
    }
    Selection[] selection = getSelection();
    if (selection.length != 0) {
        buffer.beginCompoundEdit();
        for (Selection s : selection) {
            setSelectedText(s, TextUtilities.format(getSelectedText(s), maxLineLen, buffer.getTabSize()));
        }
        buffer.endCompoundEdit();
    } else {
        int lineNo = getCaretLine();
        int start = 0, end = buffer.getLength();
        for (int i = lineNo - 1; i >= 0; i--) {
            if (lineContainsSpaceAndTabs(i)) {
                start = getLineEndOffset(i);
                break;
            }
        }
        for (int i = lineNo + 1; i < getLineCount(); i++) {
            if (lineContainsSpaceAndTabs(i)) {
                end = getLineStartOffset(i) - 1;
                break;
            }
        }
        try {
            buffer.beginCompoundEdit();
            String text = buffer.getText(start, end - start);
            int offset = getCaretPosition() - start;
            int noSpaceOffset = TextUtilities.indexIgnoringWhitespace(text, offset);
            buffer.remove(start, end - start);
            text = TextUtilities.format(text, maxLineLen, buffer.getTabSize());
            buffer.insert(start, text);
            int caretPos = start;
            if (text.length() != 0) {
                caretPos += Math.min(text.length(), TextUtilities.ignoringWhitespaceIndex(text, noSpaceOffset));
            }
            moveCaretPosition(caretPos);
        } finally {
            buffer.endCompoundEdit();
        }
    }
}