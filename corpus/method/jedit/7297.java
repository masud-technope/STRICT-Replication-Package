//}}}
//{{{ centerCaret() method
/**
	 * Centers the caret on the screen.
	 * @since jEdit 2.7pre2
	 */
public void centerCaret() {
    int offset = getScreenLineStartOffset(visibleLines >> 1);
    if (offset == -1)
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
    else
        setCaretPosition(offset);
}