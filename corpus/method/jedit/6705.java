//}}}
//{{{ getNextVisibleLine() method
/**
	 * Returns the next visible line after the specified line index,
	 * or (-1) if there is no next visible line.
	 * @param line A physical line index
	 * @since jEdit 4.0pre1
	 */
public int getNextVisibleLine(int line) {
    if (line < 0 || line >= buffer.getLineCount())
        throw new ArrayIndexOutOfBoundsException(line);
    return folds.next(line);
}