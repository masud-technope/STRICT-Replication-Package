//}}}
//{{{ getFoldLevel() method
/**
	 * Returns the fold level of the specified line.
	 * @param buffer The buffer in question
	 * @param lineIndex The line index
	 * @param seg A segment the fold handler can use to obtain any
	 * text from the buffer, if necessary
	 * @return The fold level of the specified line
	 * @since jEdit 4.0pre1
	 */
public int getFoldLevel(JEditBuffer buffer, int lineIndex, Segment seg) {
    if (lineIndex == 0)
        return 0;
    else {
        int foldLevel = buffer.getFoldLevel(lineIndex - 1);
        buffer.getLineText(lineIndex - 1, seg);
        int offset = seg.offset;
        int count = seg.count;
        int openingBrackets = 0, closingBrackets = 0;
        for (int i = 0; i < count; i++) {
            switch(seg.array[offset + i]) {
                case '{':
                    closingBrackets = 0;
                    openingBrackets++;
                    if (openingBrackets == 3) {
                        foldLevel++;
                        openingBrackets = 0;
                    }
                    break;
                case '}':
                    openingBrackets = 0;
                    closingBrackets++;
                    if (closingBrackets == 3) {
                        if (foldLevel > 0)
                            foldLevel--;
                        closingBrackets = 0;
                    }
                    break;
                default:
                    closingBrackets = openingBrackets = 0;
                    break;
            }
        }
        return foldLevel;
    }
}