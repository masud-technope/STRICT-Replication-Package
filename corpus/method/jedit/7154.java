//}}}
//{{{ getSelectionIterator() method
/**
	 * Returns the current selection.
	 * @since jEdit 4.3pre1
	 */
public Iterator<Selection> getSelectionIterator() {
    return selectionManager.selection.iterator();
}