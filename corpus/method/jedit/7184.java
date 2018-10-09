//}}}
//{{{ handlePopupTrigger() method
/**
	 * Do the same thing as right-clicking on the text area. The Gestures
	 * plugin uses this API.
	 * @since jEdit 4.2pre13
	 */
public void handlePopupTrigger(MouseEvent evt) {
    // Rebuild popup menu every time the menu is requested.
    createPopupMenu(evt);
    int x = evt.getX();
    int y = evt.getY();
    int dragStart = xyToOffset(x, y, !(painter.isBlockCaretEnabled() || isOverwriteEnabled()));
    if (getSelectionCount() == 0 || multi)
        moveCaretPosition(dragStart, false);
    GenericGUIUtilities.showPopupMenu(popup, this, x, y, false);
}