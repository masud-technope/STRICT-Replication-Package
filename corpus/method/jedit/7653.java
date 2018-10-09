//}}}
//{{{ getVirtualWidth() method
/**
	 * Returns the virtual column number (taking tabs into account) of the
	 * specified offset in the segment.
	 *
	 * @param seg The segment
	 * @param tabSize The tab size
	 */
public static int getVirtualWidth(Segment seg, int tabSize) {
    int virtualPosition = 0;
    for (int i = 0; i < seg.count; i++) {
        char ch = seg.array[seg.offset + i];
        if (ch == '\t') {
            virtualPosition += tabSize - virtualPosition % tabSize;
        } else {
            ++virtualPosition;
        }
    }
    return virtualPosition;
}