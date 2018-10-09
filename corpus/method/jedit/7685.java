//}}}
//{{{ loadStyles() methods
/**
	 * Loads the syntax styles from the properties, giving them the specified
	 * base font family and size.
	 * @param family The font family
	 * @param size The font size
	 * @since jEdit 4.3pre13
	 */
public static SyntaxStyle[] loadStyles(String family, int size) {
    return loadStyles(family, size, true);
}