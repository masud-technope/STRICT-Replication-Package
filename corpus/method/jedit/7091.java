//}}}
//{{{ setQuickCopyEnabled() method
/**
	 * Sets if clicking the middle mouse button pastes the most
	 * recent selection (% register), and if Control-dragging inserts
	 * the selection at the caret.
	 * @param quickCopy A boolean flag
	 */
public final void setQuickCopyEnabled(boolean quickCopy) {
    this.quickCopy = quickCopy;
}