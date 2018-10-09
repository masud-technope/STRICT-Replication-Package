//}}}
//{{{ getPrevVisibleLine() method
/**
	 * Returns the previous visible line before the specified line index.
	 * @param line a physical line index
	 * @return the previous visible physical line or -1 if there is no visible line
	 * @since jEdit 4.0pre1
	 */
public int getPrevVisibleLine(int line) {
    if (line < 0 || line >= buffer.getLineCount())
        throw new ArrayIndexOutOfBoundsException(line);
    return folds.prev(line);
}