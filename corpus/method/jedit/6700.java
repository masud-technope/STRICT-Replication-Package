//}}}
//{{{ getScrollLineCount() method
/**
	 * Returns the number of displayable lines
	 * It can be greater than the number of lines of the buffer when using
	 * soft wrap (a line can count for n lines), or when using folding, if
	 * the foldings are collapsed
	 * @return the number of displayable lines
	 */
public final int getScrollLineCount() {
    return scrollLineCount.getScrollLine();
}