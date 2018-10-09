//}}}
//{{{ simpleIndentLine() method
/**
	 * Simply indents the given line to the same level as the previous nonempty line
	 * @param lineIndex The line number to indent
	 * @since jEdit 5.0
	 */
public void simpleIndentLine(int lineIndex) {
    int[] whitespaceChars = new int[1];
    int prevLineIndex = getPriorNonEmptyLine(lineIndex);
    if (prevLineIndex == -1)
        return;
    String indentString = StandardUtilities.getIndentString(getLineText(prevLineIndex));
    // Do it
    try {
        beginCompoundEdit();
        int start = getLineStartOffset(lineIndex);
        remove(start, whitespaceChars[0]);
        insert(start, indentString);
    } finally {
        endCompoundEdit();
    }
}