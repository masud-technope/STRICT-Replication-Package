//}}}
//{{{ scrollDownPage() method
/**
	 * Scrolls down by one page.
	 * @since jEdit 2.7pre2
	 */
public void scrollDownPage() {
    setFirstLine(getFirstLine() + getVisibleLines() - (lastLinePartial ? 1 : 0));
}