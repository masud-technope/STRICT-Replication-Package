//}}}
//{{{ getLineText() methods
/**
	 * Returns the text on the specified line.
	 * @param lineIndex the line number
	 * @return The text, or null if the lineIndex is invalid
	 */
public final String getLineText(int lineIndex) {
    return buffer.getLineText(lineIndex);
}