//}}}
//{{{ getSelectionAtOffset() method
/**
	 * Returns the selection containing the specific offset, or <code>null</code>
	 * if there is no selection at that offset.
	 * @param offset The offset
	 * @since jEdit 3.2pre1
	 */
public Selection getSelectionAtOffset(int offset) {
    return selectionManager.getSelectionAtOffset(offset);
}