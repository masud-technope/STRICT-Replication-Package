//}}}
//{{{ selectBlock() method
/**
	 * Selects the code block surrounding the caret.
	 * @since jEdit 2.7pre2
	 */
public void selectBlock() {
    Selection s = getSelectionAtOffset(caret);
    int start, end;
    if (s == null)
        start = end = caret;
    else {
        start = s.start;
        end = s.end;
    }
    String text = getText(0, buffer.getLength());
    // We can't do the backward scan if start == 0
    if (start == 0) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    // Scan backwards, trying to find a bracket
    String openBrackets = "([{«‹⟨⌈⌊⦇⟦⦃";
    String closeBrackets = ")]}»›⟩⌉⌋⦈⟧⦄";
    int count = 1;
    char openBracket = '\0';
    char closeBracket = '\0';
    backward_scan: while (--start >= 0) {
        char c = text.charAt(start);
        int index = openBrackets.indexOf(c);
        if (index != -1) {
            if (--count == 0) {
                openBracket = c;
                closeBracket = closeBrackets.charAt(index);
                break backward_scan;
            }
        } else if (closeBrackets.indexOf(c) != -1)
            count++;
    }
    // Reset count
    count = 1;
    // Scan forward, matching that bracket
    if (openBracket == '\0') {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    forward_scan: do {
        char c = text.charAt(end);
        if (c == closeBracket) {
            if (--count == 0) {
                end++;
                break forward_scan;
            }
        } else if (c == openBracket)
            count++;
    } while (++end < buffer.getLength());
    s = new Selection.Range(start, end);
    if (multi)
        addToSelection(s);
    else
        setSelection(s);
    moveCaretPosition(end);
}