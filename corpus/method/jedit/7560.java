//}}}
//{{{ getScreenBounds() method
/**
	 * Returns the screen bounds, taking into account multi-screen
	 * environments.
	 * @since jEdit 5.3.1
	 */
public static Rectangle getScreenBounds() {
    Rectangle bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    GraphicsDevice[] devices = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
    if (devices.length > 1) {
        for (GraphicsDevice device : devices) {
            for (GraphicsConfiguration config : device.getConfigurations()) bounds = bounds.union(config.getBounds());
        }
    }
    return bounds;
}