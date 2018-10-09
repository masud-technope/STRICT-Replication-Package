//}}}
//{{{ deleteLine() method
/**
	 * Deletes the line containing the caret.
	 * @since jEdit 2.7pre2
	 */
public void deleteLine() {
    if (!buffer.isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    int x = chunkCache.subregionOffsetToX(caretLine, caret - getLineStartOffset(caretLine));
    int[] lines = getSelectedLines();
    try {
        buffer.beginCompoundEdit();
        for (int i = lines.length - 1; i >= 0; i--) {
            int start = getLineStartOffset(lines[i]);
            int end = getLineEndOffset(lines[i]);
            if (end > buffer.getLength()) {
                if (start != 0)
                    start--;
                end--;
            }
            buffer.remove(start, end - start);
        }
    } finally {
        buffer.endCompoundEdit();
    }
    int lastLine = displayManager.getLastVisibleLine();
    if (caretLine == lastLine) {
        int offset = chunkCache.xToSubregionOffset(lastLine, 0, x, true);
        setCaretPosition(buffer.getLineStartOffset(lastLine) + offset);
    } else {
        int offset = chunkCache.xToSubregionOffset(caretLine, 0, x, true);
        setCaretPosition(getLineStartOffset(caretLine) + offset);
    }
}