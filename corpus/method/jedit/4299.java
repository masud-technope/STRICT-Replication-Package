//}}}
//{{{ adjustForScreenBounds() method
/**
	 * Gives a rectangle the specified bounds, ensuring it is within the
	 * screen bounds.
	 * @since jEdit 4.2pre3
	 * @deprecated use {@link GenericGUIUtilities#adjustForScreenBounds(Rectangle)}
	 */
public static void adjustForScreenBounds(Rectangle desired) {
    GenericGUIUtilities.adjustForScreenBounds(desired);
}