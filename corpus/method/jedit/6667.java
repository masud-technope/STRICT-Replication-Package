//}}}
//{{{ searchChildren() method
/*
	 * binary search on a sorted list searches the children for one
	 * containing the line no. line returns an exact match or the closest
	 * column block just below this line use isLineWithinThisBlock on the
	 * column block returned by this method to determine whether there was
	 * an exact match
	 */
private ColumnBlock searchChildren(int line, int startIndex, int stopIndex) {
    if (children != null) {
        if (startIndex > stopIndex) {
            // column block just below this line
            return (ColumnBlock) children.get(startIndex);
        }
        int currentSearchIndex = (startIndex + stopIndex) / 2;
        int found = ((ColumnBlock) children.get(currentSearchIndex)).isLineWithinThisBlock(line);
        if (found == 0) {
            return (ColumnBlock) children.get(currentSearchIndex);
        } else if (found > 0) {
            if (children.size() - 1 > currentSearchIndex) {
                return searchChildren(line, currentSearchIndex + 1, stopIndex);
            } else {
                return null;
            }
        } else if (found < 0) {
            if (currentSearchIndex > 0) {
                return searchChildren(line, startIndex, currentSearchIndex - 1);
            } else {
                // line
                return (ColumnBlock) children.get(0);
            }
        }
    }
    return null;
}