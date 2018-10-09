//}}}
//{{{ getSelection() method
/**
	 * Returns the current selection.
	 * @since jEdit 3.2pre1
	 */
@Nonnull
public Selection[] getSelection() {
    return selection.toArray(new Selection[selection.size()]);
}