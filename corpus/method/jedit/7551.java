//}}}
//{{{ showPopupMenu() method
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
	 * @since jEdit 5.3.1
	 */
public static void showPopupMenu(JPopupMenu popup, Component comp, int x, int y, boolean point) {
    int offsetX = 0;
    int offsetY = 0;
    int extraOffset = point ? 1 : 0;
    Component win = comp;
    while (!(win instanceof Window || win == null)) {
        offsetX += win.getX();
        offsetY += win.getY();
        win = win.getParent();
    }
    if (win != null) {
        Dimension size = popup.getPreferredSize();
        Rectangle screenSize = getScreenBounds();
        if (x + offsetX + size.width + win.getX() > screenSize.width && x + offsetX + win.getX() >= size.width) {
            //System.err.println("x overflow");
            if (point)
                x -= size.width + extraOffset;
            else
                x = win.getWidth() - size.width - offsetX + extraOffset;
        } else {
            x += extraOffset;
        }
        //	+ ",win.height=" + win.getHeight());
        if (y + offsetY + size.height + win.getY() > screenSize.height && y + offsetY + win.getY() >= size.height) {
            if (point)
                y = win.getHeight() - size.height - offsetY + extraOffset;
            else
                y = -size.height - 1;
        } else {
            y += extraOffset;
        }
        popup.show(comp, x, y);
    } else
        popup.show(comp, x + extraOffset, y + extraOffset);
}