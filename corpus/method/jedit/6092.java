/**
	 * Insets the contents of the specified register into the text area.
	 * @param textArea The text area
	 * @param register The register
	 * @param preferredDataFlavor the preferred dataflavor. If not available
	 * <tt>DataFlavor.stringFlavor</tt> will be used
	 * @since jEdit 4.4pre1
	 */
public static void paste(TextArea textArea, char register, DataFlavor preferredDataFlavor) {
    paste(textArea, register, false, preferredDataFlavor);
}