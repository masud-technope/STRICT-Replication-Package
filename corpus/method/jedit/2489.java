//}}}
//{{{ getPriorNonEmptyLine() method
/**
	 * Auto indent needs this.
	 * @param lineIndex the line
	 * @return the previous non-empty line
	 */
public int getPriorNonEmptyLine(int lineIndex) {
    if (!mode.getIgnoreWhitespace()) {
        return lineIndex - 1;
    }
    int returnValue = -1;
    for (int i = lineIndex - 1; i >= 0; i--) {
        Segment seg = new Segment();
        getLineText(i, seg);
        if (seg.count != 0)
            returnValue = i;
        for (int j = 0; j < seg.count; j++) {
            char ch = seg.array[seg.offset + j];
            if (!Character.isWhitespace(ch))
                return i;
        }
    }
    // so return index of prior whitespace line
    return returnValue;
}