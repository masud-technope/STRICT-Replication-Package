//}}}
//{{{ append() methods
/**
	 * Appends the text selected in the text area to the specified register,
	 * with a newline between the old and new text.
	 * @param textArea The text area
	 * @param register The register
	 */
public static void append(TextArea textArea, char register) {
    append(textArea, register, "\n", false);
}