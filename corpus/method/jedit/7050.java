//}}}
//{{{ toggleRectangularSelectionEnabled() method
/**
	 * Toggles rectangular selection.
	 * @since jEdit 4.2pre1
	 */
public final void toggleRectangularSelectionEnabled() {
    setRectangularSelectionEnabled(!rectangularSelectionMode);
    if (getSelectionCount() == 1) {
        Selection s = getSelection(0);
        removeFromSelection(s);
        if (rectangularSelectionMode) {
            addToSelection(new Selection.Rect(s.getStart(), s.getEnd()));
        } else {
            addToSelection(new Selection.Range(s.getStart(), s.getEnd()));
        }
    }
}