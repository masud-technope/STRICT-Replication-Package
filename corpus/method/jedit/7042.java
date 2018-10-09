//}}}
//{{{ scrollUpPage() method
/**
	 * Scrolls up by one page.
	 * @since jEdit 2.7pre2
	 */
public void scrollUpPage() {
    setFirstLine(getFirstLine() - getVisibleLines() + (lastLinePartial ? 1 : 0));
}