//}}}
//{{{ getSelectedLines() method
/**
	 * Returns a sorted array of line numbers on which a selection or
	 * selections are present.<p>
	 *
	 * This method is the most convenient way to iterate through selected
	 * lines in a buffer. The line numbers in the array returned by this
	 * method can be passed as a parameter to such methods as
	 * {@link org.gjt.sp.jedit.Buffer#getLineText(int)}.
	 */
int[] getSelectedLines() {
    Set<Integer> set = new TreeSet<Integer>();
    for (Selection s : selection) {
        int endLine = s.end == textArea.getLineStartOffset(s.endLine) ? s.endLine - 1 : s.endLine;
        for (int j = s.startLine; j <= endLine; j++) {
            set.add(j);
        }
    }
    int[] returnValue = new int[set.size()];
    int i = 0;
    for (Integer line : set) returnValue[i++] = line;
    return returnValue;
}