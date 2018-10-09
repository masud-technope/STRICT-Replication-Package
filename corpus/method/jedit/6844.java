//}}}
//{{{ showGoToLineDialog() method
/**
	 * Displays the 'go to line' dialog box, and moves the caret to the
	 * specified line number, or moves the caret back or forward by the offset provided.
	 * 
	 * @since jEdit 2.7pre2
	 */
public void showGoToLineDialog() {
    int maxLine = Integer.valueOf(buffer.getLineCount());
    String line = GUIUtilities.input(view, "goto-line", new Integer[] { 1, maxLine }, null);
    if (line == null)
        return;
    try {
        int lineNumber = 0;
        if (Pattern.matches("-\\d+", line) || Pattern.matches("\\+\\d+", line)) {
            int offset = Integer.parseInt(line);
            lineNumber = caretLine + offset;
        } else {
            lineNumber = Integer.parseInt(line) - 1;
        }
        if (lineNumber > --maxLine)
            lineNumber = maxLine;
        if (lineNumber < 0)
            lineNumber = 0;
        EditBus.send(new PositionChanging(this));
        setCaretPosition(getLineStartOffset(lineNumber));
    } catch (Exception e) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
    }
}