//}}}
//{{{ saveGeometry() method
/**
	 * Saves a window's geometry to the properties.
	 * The geometry is saved to the <code><i>name</i>.x</code>,
	 * <code><i>name</i>.y</code>, <code><i>name</i>.width</code> and
	 * <code><i>name</i>.height</code> properties.<br>
	 * For Frame's and descendents use {@link #addSizeSaver(Frame,Container,String)} to save the sizes
	 * correct even if the Frame is in maximized or iconified state.
	 * @param win The window to load geometry from
	 * @param parent The parent frame to be relative to.
	 * @param name The name of the window
	 * @see #addSizeSaver(Frame,Container,String)
	 */
public static void saveGeometry(Window win, Container parent, String name) {
    if (win instanceof Frame) {
        jEdit.setIntegerProperty(name + ".extendedState", ((Frame) win).getExtendedState());
    }
    Rectangle bounds = win.getBounds();
    int x = bounds.x;
    int y = bounds.y;
    if (parent != null) {
        Rectangle parentBounds = parent.getBounds();
        x -= parentBounds.x;
        y -= parentBounds.y;
    }
    jEdit.setIntegerProperty(name + ".x", x);
    jEdit.setIntegerProperty(name + ".y", y);
    jEdit.setIntegerProperty(name + ".width", bounds.width);
    jEdit.setIntegerProperty(name + ".height", bounds.height);
}