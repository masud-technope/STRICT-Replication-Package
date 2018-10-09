//}}}
//{{{ scrollTo() methods
/**
	 * Ensures that the specified location in the buffer is visible.
	 * @param offset The offset from the start of the buffer
	 * @param doElectricScroll If true, electric scrolling will be performed
	 * @since jEdit 4.2pre3
	 */
public void scrollTo(int offset, boolean doElectricScroll) {
    int line = buffer.getLineOfOffset(offset);
    scrollTo(line, offset - buffer.getLineStartOffset(line), doElectricScroll);
}