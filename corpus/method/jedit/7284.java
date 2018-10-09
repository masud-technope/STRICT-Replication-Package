//}}}
//{{{ lineContainsSpaceAndTabs() method
/**
	 * Check if the line contains only spaces and tabs.
	 *
	 * @param lineIndex the line index
	 * @return <code>true</code> if the line contains only spaces and tabs
	 */
private boolean lineContainsSpaceAndTabs(int lineIndex) {
    final Segment lineSegment = new Segment();
    getLineText(lineIndex, lineSegment);
    for (int j = 0; j < lineSegment.count; j++) {
        switch(lineSegment.array[lineSegment.offset + j]) {
            case ' ':
            case '\t':
                break;
            default:
                return false;
        }
    }
    return true;
}