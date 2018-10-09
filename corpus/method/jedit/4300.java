//}}}
//{{{ loadGeometry() method
/**
	 * Loads a windows's geometry from the properties.
	 * The geometry is loaded from the <code><i>name</i>.x</code>,
	 * <code><i>name</i>.y</code>, <code><i>name</i>.width</code> and
	 * <code><i>name</i>.height</code> properties.
	 *
	 * @param win The window to load geometry from
	 * @param name The name of the window
	 */
public static void loadGeometry(Window win, String name) {
    loadGeometry(win, win.getParent(), name);
}