//}}}
//{{{ getLineOfOffset() method
public int getLineOfOffset(int offset) {
    /*
		 * Performance optimization: assumption is that this method
		 * is called many times for the same line.
		 * Not optimizing the first line is intentional,
		 * profiling proves this is the right approach (#3528212).
		 */
    if (getLineOfOffsetLine > 0 && getLineOfOffsetLine < lineCount) {
        int s = getLineEndOffset(getLineOfOffsetLine - 1);
        int e = getLineEndOffset(getLineOfOffsetLine);
        if (offset >= s && offset < e)
            return getLineOfOffsetLine;
    }
    int start = 0;
    int end = lineCount - 1;
    for (; ; ) {
        switch(end - start) {
            case 0:
                if (getLineEndOffset(start) <= offset)
                    getLineOfOffsetLine = start + 1;
                else
                    getLineOfOffsetLine = start;
                return getLineOfOffsetLine;
            case 1:
                if (getLineEndOffset(start) <= offset) {
                    if (getLineEndOffset(end) <= offset)
                        getLineOfOffsetLine = end + 1;
                    else
                        getLineOfOffsetLine = end;
                } else
                    getLineOfOffsetLine = start;
                return getLineOfOffsetLine;
            default:
                int pivot = (end + start) / 2;
                int value = getLineEndOffset(pivot);
                if (value == offset) {
                    getLineOfOffsetLine = pivot + 1;
                    return getLineOfOffsetLine;
                } else if (value < offset)
                    start = pivot + 1;
                else
                    end = pivot - 1;
                break;
        }
    }
}