//}}}
//{{{ addToSelection() method
/**
	 * Adds to the selection. Nested and overlapping selections are merged
	 * where possible. Null elements of the array are ignored.
	 * @param selection The new selection
	 * since jEdit 3.2pre1
	 */
void addToSelection(Selection[] selection) {
    if (selection != null) {
        for (Selection s : selection) {
            if (s != null)
                addToSelection(s);
        }
    }
}