/**
	 * Appends the text selected in the text area to the specified register.
	 * @param textArea The text area
	 * @param register The register
	 * @param separator The separator to insert between the old and new text
	 */
public static void append(TextArea textArea, char register, String separator) {
    append(textArea, register, separator, false);
}