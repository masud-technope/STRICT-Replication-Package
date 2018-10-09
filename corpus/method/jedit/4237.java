//}}}
//{{{ addSizeSaver() method
/**
	 * Adds a SizeSaver to the specified Frame. For non-Frame's use {@link #saveGeometry(Window,Container,String)}
	 *
	 * @param frame The Frame for which to save the size
	 * @param parent The parent to be relative to
	 * @param name The prefix for the settings
	 * @since jEdit 4.3pre7
	 * @see #saveGeometry(Window,Container,String)
	 */
public static void addSizeSaver(Frame frame, Container parent, String name) {
    SizeSaver ss = new SizeSaver(frame, parent, name);
    frame.addWindowStateListener(ss);
    frame.addComponentListener(ss);
}