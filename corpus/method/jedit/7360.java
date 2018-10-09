//}}}
//{{{ nextTabStop() method
/**
	 * Implementation of TabExpander interface. Returns next tab stop after
	 * a specified point.
	 * @param x The x co-ordinate
	 * @param tabOffset Ignored
	 * @return The next tab stop after <i>x</i>
	 */
public float nextTabStop(float x, int tabOffset) {
    int ntabs = (int) (x / textArea.tabSize);
    return (ntabs + 1) * textArea.tabSize;
}