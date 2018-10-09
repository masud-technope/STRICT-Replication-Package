//}}}
//{{{ setFirstPhysicalLine() methods
/**
	 * Sets the vertical scroll bar position.
	 * @param physFirstLine The first physical line to display
	 * @since jEdit 4.2pre1
	 */
public void setFirstPhysicalLine(int physFirstLine) {
    if (physFirstLine < 0)
        physFirstLine = 0;
    setFirstPhysicalLine(physFirstLine, 0);
}