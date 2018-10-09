//}}}
//}}}
//{{{ Loading, saving window geometry
//{{{ loadGeometry() method
/**
	 * Loads a windows's geometry from the properties.
	 * The geometry is loaded from the <code><i>name</i>.x</code>,
	 * <code><i>name</i>.y</code>, <code><i>name</i>.width</code> and
	 * <code><i>name</i>.height</code> properties.
	 *
	 * @param win The window to load geometry from
	 * @param parent The parent frame to be relative to.
	 * @param name The name of the window
	 */
public static void loadGeometry(Window win, Container parent, String name) {
    Dimension size = win.getSize();
    int width = jEdit.getIntegerProperty(name + ".width", size.width);
    int height = jEdit.getIntegerProperty(name + ".height", size.height);
    int x = jEdit.getIntegerProperty(name + ".x", 50);
    int y = jEdit.getIntegerProperty(name + ".y", 50);
    if (parent != null) {
        Point location = parent.getLocation();
        x = location.x + x;
        y = location.y + y;
    }
    int extState = jEdit.getIntegerProperty(name + ".extendedState", Frame.NORMAL);
    Rectangle desired = new Rectangle(x, y, width, height);
    try {
        if (!Debug.DISABLE_MULTIHEAD)
            GenericGUIUtilities.adjustForScreenBounds(desired);
    } catch (Exception e) {
        Log.log(Log.ERROR, GUIUtilities.class, e);
    }
    if (OperatingSystem.isX11() && Debug.GEOMETRY_WORKAROUND)
        new UnixWorkaround(win, name, desired, extState);
    else {
        win.setBounds(desired);
        if (win instanceof Frame)
            ((Frame) win).setExtendedState(extState);
    }
}