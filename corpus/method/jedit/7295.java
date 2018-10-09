//}}}
// {{{ scrollAndCenterCaret() method
/**
	 * Tries to scroll the textArea so that the caret is centered on the screen.
	 * Sometimes gets confused by folds but at least makes the caret visible and
	 * guesses better on subsequent attempts.
	 *
	 * @since jEdit 4.3pre15
	 */
public void scrollAndCenterCaret() {
    if (!getDisplayManager().isLineVisible(getCaretLine()))
        getDisplayManager().expandFold(getCaretLine(), true);
    int physicalLine = getCaretLine();
    int midPhysicalLine = getPhysicalLineOfScreenLine(visibleLines >> 1);
    int diff = physicalLine - midPhysicalLine;
    setFirstLine(getFirstLine() + diff);
    requestFocus();
}