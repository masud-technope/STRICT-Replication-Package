//}}}
//{{{ goToPrevParagraph() method
/**
	 * Moves the caret to the start of the previous paragraph.
	 * @param select true if you want to extend selection
	 * @since jEdit 2.7pre2
	 */
public void goToPrevParagraph(boolean select) {
    int lineNo = caretLine;
    int newCaret = 0;
    boolean foundBlank = false;
    final Segment lineSegment = new Segment();
    loop: for (int i = lineNo - 1; i >= 0; i--) {
        if (!displayManager.isLineVisible(i))
            continue;
        getLineText(i, lineSegment);
        for (int j = 0; j < lineSegment.count; j++) {
            switch(lineSegment.array[lineSegment.offset + j]) {
                case ' ':
                case '\t':
                    break;
                default:
                    if (foundBlank) {
                        newCaret = getLineEndOffset(i) - 1;
                        break loop;
                    } else
                        continue loop;
            }
        }
        foundBlank = true;
    }
    if (select)
        extendSelection(caret, newCaret);
    else if (!multi)
        selectNone();
    moveCaretPosition(newCaret);
}