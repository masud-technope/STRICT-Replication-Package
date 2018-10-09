//}}}
//{{{ paste() methods
/**
	 * Insets the contents of the specified register into the text area.
	 * @param textArea The text area
	 * @param register The register
	 * @since jEdit 2.7pre2
	 */
public static void paste(TextArea textArea, char register) {
    paste(textArea, register, false);
}