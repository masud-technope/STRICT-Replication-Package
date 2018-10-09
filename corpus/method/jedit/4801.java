//}}}
//{{{ getMode() method
/**
	 * Returns the edit mode with the specified name.
	 * @param name The edit mode
	 */
public static Mode getMode(String name) {
    return ModeProvider.instance.getMode(name);
}