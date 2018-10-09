//}}}
//{{{ showPopupMenu() method - copied from GUIUtilities
/**
	 * Shows the specified popup menu, ensuring it is displayed within
	 * the bounds of the screen.
	 * @param popup The popup menu
	 * @param comp The component to show it for
	 * @param x The x co-ordinate
	 * @param y The y co-ordinate
	 * @param point If true, then the popup originates from a single point;
	 * otherwise it will originate from the component itself. This affects
	 * positioning in the case where the popup does not fit onscreen.
	 *
	 * FIXME: move parts of GUIUtilities compatible with standalone TextArea in a separate
	 * class, to prevent such copies
	 *
	 * @since jEdit 4.1pre1
	 * @deprecated use {@link GenericGUIUtilities#showPopupMenu(JPopupMenu, Component, int, int, boolean)}
	 */
public static void showPopupMenu(JPopupMenu popup, Component comp, int x, int y, boolean point) {
    GenericGUIUtilities.showPopupMenu(popup, comp, x, y, point);
}