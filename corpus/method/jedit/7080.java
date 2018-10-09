//}}}
//{{{ getLastScreenLine() method
/**
	 * Returns the last screen line index, it is different from
	 * {@link #getVisibleLines()} because the buffer can have less lines than
	 * the visible lines
	 * @return the last screen line index.
	 * @since jEdit 4.3pre1
	 */
public int getLastScreenLine() {
    return screenLastLine;
}