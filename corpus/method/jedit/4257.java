//}}}
//{{{ saveGeometry() method
/**
	 * Saves a window's geometry to the properties.
	 * The geometry is saved to the <code><i>name</i>.x</code>,
	 * <code><i>name</i>.y</code>, <code><i>name</i>.width</code> and
	 * <code><i>name</i>.height</code> properties.<br>
	 * For Frame's and descendents use {@link #addSizeSaver(Frame,String)} to save the sizes
	 * correct even if the Frame is in maximized or iconified state.
	 * @param win The window to load geometry from
	 * @param name The name of the window
	 * @see #addSizeSaver(Frame,String)
	 */
public static void saveGeometry(Window win, String name) {
    saveGeometry(win, win.getParent(), name);
}