//}}}
//{{{ setSelection() method
/**
	 * Sets the selection. Nested and overlapping selections are merged
	 * where possible.
	 */
void setSelection(Selection selection) {
    this.selection.clear();
    if (selection != null)
        addToSelection(selection);
}