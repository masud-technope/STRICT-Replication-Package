//}}}
//{{{ showPopupMenu() method
/**
	 * Shows the popup menu below the current caret position.
	 * @since 4.3pre10
	 */
public void showPopupMenu() {
    if (!popup.isVisible() && hasFocus()) {
        Point caretPos = offsetToXY(getCaretPosition());
        if (caretPos != null) {
            // Open the context menu below the caret
            int charHeight = getPainter().getLineHeight();
            GenericGUIUtilities.showPopupMenu(popup, painter, caretPos.x, caretPos.y + charHeight, true);
        }
    }
}