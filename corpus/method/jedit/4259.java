//}}}
//{{{ isRightButton() method
/**
	 * @param modifiers The modifiers flag from a mouse event
	 * @since jEdit 4.1pre9
	 * @deprecated use {@link GenericGUIUtilities#isRightButton(int)}
	 */
public static boolean isRightButton(int modifiers) {
    return GenericGUIUtilities.isRightButton(modifiers);
}