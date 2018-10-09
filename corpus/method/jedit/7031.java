//}}}
//{{{ deleteParagraph() method
/**
	 * Deletes the paragraph containing the caret.
	 * @since jEdit 2.7pre2
	 */
public void deleteParagraph() {
    if (!buffer.isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    // find the beginning of the paragraph.
    int start = 0;
    for (int i = caretLine - 1; i >= 0; i--) {
        if (lineContainsSpaceAndTabs(i)) {
            start = getLineStartOffset(i);
            break;
        }
    }
    // Find the end of the paragraph
    int end = buffer.getLength();
    for (int i = caretLine + 1; i < getLineCount(); i++) {
        if (lineContainsSpaceAndTabs(i)) {
            end = getLineEndOffset(i) - 1;
            break;
        }
    }
    buffer.remove(start, end - start);
}