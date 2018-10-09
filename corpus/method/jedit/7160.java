//}}}
//{{{ getSelection() methods
/**
	 * Returns the current selection.
	 * @since jEdit 3.2pre1
	 */
@Nonnull
public Selection[] getSelection() {
    return selectionManager.getSelection();
}