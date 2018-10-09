/**
	 * Indents all specified lines.
	 * @param lines The line numbers
	 * @since jEdit 3.2pre1
	 */
public void indentLines(int[] lines) {
    try {
        beginCompoundEdit();
        for (int line : lines) indentLine(line, true);
    } finally {
        endCompoundEdit();
    }
}