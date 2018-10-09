//}}}
//{{{ getMaxHorizontalScrollWidth() method
/**
	 * Returns the max line width of the textarea.
	 * It will check all lines in the line info array.
	 *
	 * @return the max line width
	 */
int getMaxHorizontalScrollWidth() {
    int max = 0;
    for (int i = 0; i < lineInfo.length; i++) {
        LineInfo info = lineInfo[i];
        if (info.width > max)
            max = info.width;
    }
    return max;
}