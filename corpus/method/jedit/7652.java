//}}}
//{{{ getOffsetOfVirtualColumn() method
/**
	 * Returns the array offset of a virtual column number (taking tabs
	 * into account) in the segment.
	 *
	 * @param seg The segment
	 * @param tabSize The tab size
	 * @param column The virtual column number
	 * @param totalVirtualWidth If this array is non-null, the total
	 * virtual width will be stored in its first location if this method
	 * returns -1.
	 *
	 * @return -1 if the column is out of bounds
	 */
public static int getOffsetOfVirtualColumn(Segment seg, int tabSize, int column, int[] totalVirtualWidth) {
    int virtualPosition = 0;
    for (int i = 0; i < seg.count; i++) {
        char ch = seg.array[seg.offset + i];
        if (ch == '\t') {
            int tabWidth = tabSize - virtualPosition % tabSize;
            if (virtualPosition >= column)
                return i;
            else
                virtualPosition += tabWidth;
        } else {
            if (virtualPosition >= column)
                return i;
            else
                ++virtualPosition;
        }
    }
    if (totalVirtualWidth != null)
        totalVirtualWidth[0] = virtualPosition;
    return -1;
}