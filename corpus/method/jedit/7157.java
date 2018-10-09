/**
	 * Returns the selection with the specified index. This must be
	 * between 0 and the return value of <code>getSelectionCount()</code>.
	 * @since jEdit 4.3pre1
	 * @param index the index of the selection you want
	 */
public Selection getSelection(int index) {
    return selectionManager.selection.get(index);
}