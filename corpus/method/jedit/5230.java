//{{{ getScreenBounds() method
/**
	 * Returns the bounds of the default screen.
	 */
public static Rectangle getScreenBounds() {
    int screenX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    int screenY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    int x, y, w, h;
    if (isMacOS()) {
        x = 0;
        y = 22;
        w = screenX;
        //shadow size
        h = screenY - y - 4;
    } else if (isWindows()) {
        x = -4;
        y = -4;
        w = screenX - 2 * x;
        h = screenY - 2 * y;
    } else {
        x = 0;
        y = 0;
        w = screenX;
        h = screenY;
    }
    return new Rectangle(x, y, w, h);
}