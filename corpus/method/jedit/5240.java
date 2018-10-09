//}}}
//{{{ getScreenBounds() method
/**
	 * Returns the bounds of the (virtual) screen that the window should be in
	 * @param window The bounds of the window to get the screen for
	 */
public static Rectangle getScreenBounds(Rectangle window) {
    GraphicsDevice[] gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
    Set<GraphicsConfiguration> intersects = new HashSet<GraphicsConfiguration>();
    // many items it should be fine
    for (GraphicsDevice aGd : gd) {
        GraphicsConfiguration gc = aGd.getDefaultConfiguration();
        // Don't add duplicates
        if (window.intersects(gc.getBounds())) {
            if (!intersects.contains(gc))
                intersects.add(gc);
        }
    }
    GraphicsConfiguration choice = null;
    if (!intersects.isEmpty()) {
        // Pick screen with largest intersection
        for (GraphicsConfiguration gcc : intersects) {
            if (choice == null)
                choice = gcc;
            else {
                Rectangle int1 = choice.getBounds().intersection(window);
                Rectangle int2 = gcc.getBounds().intersection(window);
                int area1 = int1.width * int1.height;
                int area2 = int2.width * int2.height;
                if (area2 > area1)
                    choice = gcc;
            }
        }
    } else
        choice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
    // Make adjustments for some OS's
    int screenX = choice.getBounds().x;
    int screenY = choice.getBounds().y;
    int screenW = choice.getBounds().width;
    int screenH = choice.getBounds().height;
    int x, y, w, h;
    if (isMacOS()) {
        x = screenX;
        y = screenY + 22;
        w = screenW;
        //shadow size
        h = screenH - y - 4;
    } else {
        x = screenX;
        y = screenY;
        w = screenW;
        h = screenH;
    }
    // Yay, we're finally there
    return new Rectangle(x, y, w, h);
}