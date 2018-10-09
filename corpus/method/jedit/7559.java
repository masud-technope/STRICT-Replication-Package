//}}}
//{{{ showPopupMenu() method
/**
	 * Shows the specified popup menu, ensuring it is displayed within
	 * the bounds of the screen.
	 * @param popup The popup menu
	 * @param comp The component to show it for
	 * @param x The x co-ordinate
	 * @param y The y co-ordinate
	 * @since jEdit 4.0pre1
	 * @see javax.swing.JComponent#setComponentPopupMenu(javax.swing.JPopupMenu) setComponentPopupMenu
	 * which works better and is simpler to use: you don't have to write the code to
	 * show/hide popups in response to mouse events anymore.
	 * @since jEdit 5.3.1
	 */
public static void showPopupMenu(JPopupMenu popup, Component comp, int x, int y) {
    showPopupMenu(popup, comp, x, y, true);
}