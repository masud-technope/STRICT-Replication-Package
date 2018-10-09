//}}}
//{{{ addMarker() method
/**
	 * Adds a marker at the caret position.
	 * @since jEdit 3.2pre1
	 */
public void addMarker() {
    int caretLine = textArea.getCaretLine();
    // always add markers on selected lines
    Selection[] selection = textArea.getSelection();
    for (Selection s : selection) {
        int startLine = s.getStartLine();
        if (startLine != s.getEndLine() && startLine != caretLine) {
            buffer.addMarker('\0', s.getStart());
        }
        if (s.getEndLine() != caretLine)
            buffer.addMarker('\0', s.getEnd());
    }
    // toggle marker on caret line
    buffer.addOrRemoveMarker('\0', textArea.getCaretPosition());
}