//}}}
//{{{ getScreenBounds() method
/**
	 * Returns the screen bounds, taking into account multi-screen
	 * environments.
	 * @since jEdit 4.3pre18
	 * @deprecated use {@link GenericGUIUtilities#getScreenBounds()}
	 */
public static Rectangle getScreenBounds() {
    return GenericGUIUtilities.getScreenBounds();
}