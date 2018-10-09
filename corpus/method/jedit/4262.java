//}}}
//{{{ requestFocus() method
/**
	 * Focuses on the specified component as soon as the window becomes
	 * active.
	 * @param win The window
	 * @param comp The component
	 * @deprecated use {@link GenericGUIUtilities#requestFocus(Window, Component)}
	 */
public static void requestFocus(final Window win, final Component comp) {
    GenericGUIUtilities.requestFocus(win, comp);
}