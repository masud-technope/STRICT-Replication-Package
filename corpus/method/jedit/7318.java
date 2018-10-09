//}}}
//{{{ isRightButton() method
/**
	 * @param modifiers The modifiers flag from a mouse event
	 * @return true if the modifier match the right button
	 * @since jEdit 4.3pre7
	 */
public static boolean isRightButton(int modifiers) {
    if (OperatingSystem.isMacOS()) {
        if ((modifiers & BUTTON1_DOWN_MASK) == BUTTON1_DOWN_MASK)
            return (modifiers & CTRL_DOWN_MASK) == CTRL_DOWN_MASK;
        else
            return (modifiers & BUTTON3_DOWN_MASK) == BUTTON3_DOWN_MASK;
    } else
        return (modifiers & BUTTON3_DOWN_MASK) == BUTTON3_DOWN_MASK;
}