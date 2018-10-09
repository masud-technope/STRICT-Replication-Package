//}}}
//{{{ isMiddleButton() method
/**
	 * @param modifiers The modifiers flag from a mouse event
	 * @since jEdit 4.1pre9
	 * @deprecated use {@link GenericGUIUtilities#isMiddleButton(int)}
	 */
public static boolean isMiddleButton(int modifiers) {
    return GenericGUIUtilities.isMiddleButton(modifiers);
}