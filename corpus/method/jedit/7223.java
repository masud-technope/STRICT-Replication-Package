//}}}
//{{{ getLineStartOffset() method
/**
	 * Returns the start offset of the specified line.
	 * @param line The line (physical line)
	 * @return The start offset of the specified line, or -1 if the line is
	 * invalid
	 */
public int getLineStartOffset(int line) {
    return buffer.getLineStartOffset(line);
}