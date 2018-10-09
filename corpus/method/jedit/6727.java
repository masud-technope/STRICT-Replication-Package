//}}}
//{{{ setScreenLineCount() method
/**
	 * Sets the number of screen lines that the specified physical line
	 * is split into.
	 * @param line the physical line number
	 * @param count the line count (== 1 if no wrap, > 1 if soft wrap)
	 * @since jEdit 4.2pre1
	 */
private void setScreenLineCount(int line, int count) {
    assert count > 0;
    screenLineMgr.setScreenLineCount(line, count);
}