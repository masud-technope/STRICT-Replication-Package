//}}}
//{{{ narrowToFold() method
/**
	 * Hides all lines except those in the fold containing the caret.
	 * @since jEdit 4.0pre1
	 */
public void narrowToFold() {
    int[] lines = buffer.getFoldAtLine(caretLine);
    if (lines[0] == 0 && lines[1] == buffer.getLineCount() - 1)
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
    else
        displayManager.narrow(lines[0], lines[1]);
}