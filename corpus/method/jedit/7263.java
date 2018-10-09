//}}}
//{{{ getSelectedLines() method
/**
	 * Returns a sorted array of line numbers on which a selection or
	 * selections are present.<p>
	 *
	 * This method is the most convenient way to iterate through selected
	 * lines in a buffer. The line numbers in the array returned by this
	 * method can be passed as a parameter to such methods as
	 * {@link JEditBuffer#getLineText(int)}.
	 *
	 * @return Non-null, non-zero sized array of line indexes. If no lines are
	 * actually selected, return the caret line in the array.
	 * @since jEdit 3.2pre1
	 */
public int[] getSelectedLines() {
    if (selectionManager.getSelectionCount() == 0)
        return new int[] { caretLine };
    return selectionManager.getSelectedLines();
}