//}}}
//{{{ getLineEndOffset() method
/**
	 * Returns the end offset of the specified line.
	 * @param line The line (physical line)
	 * @return The end offset of the specified line, or -1 if the line is
	 * invalid.
	 */
public int getLineEndOffset(int line) {
    return buffer.getLineEndOffset(line);
}