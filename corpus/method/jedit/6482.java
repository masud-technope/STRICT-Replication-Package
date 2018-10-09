//}}}
//{{{ getMode() method
/**
	 * Returns the edit mode with the specified name.
	 * @param name The edit mode
	 * @since jEdit 4.3pre10
	 */
public Mode getMode(String name) {
    return modes.get(name);
}