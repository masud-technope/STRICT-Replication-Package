//}}}
//{{{ isMiddleButton() method
/**
	 * @param modifiers The modifiers flag from a mouse event
	 * @return true if the modifier match the middle button
	 * @since jEdit 4.3pre7
	 */
public static boolean isMiddleButton(int modifiers) {
    if (OperatingSystem.isMacOS()) {
        if ((modifiers & BUTTON1_DOWN_MASK) == BUTTON1_DOWN_MASK)
            return (modifiers & ALT_DOWN_MASK) == ALT_DOWN_MASK;
        else
            return (modifiers & BUTTON2_DOWN_MASK) == BUTTON2_DOWN_MASK;
    } else
        return (modifiers & BUTTON2_DOWN_MASK) == BUTTON2_DOWN_MASK;
}