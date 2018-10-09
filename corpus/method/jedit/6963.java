//}}}
//{{{ getSelectionAtOffset() method
/**
	 * Returns the selection containing the specific offset, or <code>null</code>
	 * if there is no selection at that offset.
	 * @param offset The offset
	 * @since jEdit 3.2pre1
	 */
Selection getSelectionAtOffset(int offset) {
    if (selection != null) {
        for (Selection s : selection) {
            if (offset >= s.start && offset <= s.end)
                return s;
        }
    }
    return null;
}