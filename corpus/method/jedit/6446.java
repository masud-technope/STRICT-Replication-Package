//}}}
//{{{ isTab() method
/**
	 * Returns true if this chunk represents a tab.
	 */
final boolean isTab(Segment lineText) {
    return length == 1 && lineText.array[lineText.offset + offset] == '\t';
}