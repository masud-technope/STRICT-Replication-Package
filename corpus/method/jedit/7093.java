//}}}
//{{{ isQuickCopyEnabled() method
/**
	 * Returns if clicking the middle mouse button pastes the most
	 * recent selection (% register), and if Control-dragging inserts
	 * the selection at the caret.
	 */
public final boolean isQuickCopyEnabled() {
    return quickCopy;
}