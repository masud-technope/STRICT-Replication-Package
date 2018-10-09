//}}}
//{{{ addSizeSaver() method
/**
	* Adds a SizeSaver to the specified Frame. For non-Frame's use {@link #saveGeometry(Window,String)}
	 *
	 * @param frame The Frame for which to save the size
	 * @param name The prefix for the settings
	 * @since jEdit 4.3pre6
	 * @see #saveGeometry(Window,String)
	 */
public static void addSizeSaver(Frame frame, String name) {
    addSizeSaver(frame, frame.getParent(), name);
}