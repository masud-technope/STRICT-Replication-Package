//}}}
//{{{ adjustForScreenBounds() method
/**
	 * Gives a rectangle the specified bounds, ensuring it is within the
	 * screen bounds.
	 * @since jEdit 5.3.1
	 */
public static void adjustForScreenBounds(Rectangle desired) {
    // Make sure the window is displayed in visible region
    Rectangle osbounds = OperatingSystem.getScreenBounds(desired);
    if (desired.width > osbounds.width) {
        desired.width = osbounds.width;
    }
    if (desired.x < osbounds.x) {
        desired.x = osbounds.x;
    }
    if (desired.x + desired.width > osbounds.x + osbounds.width) {
        desired.x = osbounds.x + osbounds.width - desired.width;
    }
    if (desired.height > osbounds.height) {
        desired.height = osbounds.height;
    }
    if (desired.y < osbounds.y) {
        desired.y = osbounds.y;
    }
    if (desired.y + desired.height > osbounds.y + osbounds.height) {
        desired.y = osbounds.y + osbounds.height - desired.height;
    }
}