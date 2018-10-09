//}}}
//{{{ Private methods
//{{{ getSelectionPivotCaret() method
/*
	 * Dynamically get the "pivot" point associated with a current
	 * selection.  See inline comments for details.
	 */
private int getSelectionPivotCaret() {
    int caret = textArea.caret;
    Selection s = textArea.getSelectionAtOffset(textArea.caret);
    if (s == null)
        return caret;
    // The mental model: an existing selection, and then a shift+click
    // somewhere else.  What happens to the selection?  Because a selection
    // exists, we need a "pivot" point.  If the caret is at the start of a
    // selection, the end of the selection pivot point.  So, a click above
    // the start of the caret will enlarge the selection, and a click below
    // the end will reverse the selection around the pivot point: the text
    // before the pivot will no longer be selected, and the text after it
    // and up to the click will be newly selected.  Vice versa holds true
    // when the caret is at the end of the selection.  If the caret is
    // somewhere else, just give up, and let the user fix it.
    caret = (caret == s.start ? s.end : caret == s.end ? s.start : caret);
    return caret;
}