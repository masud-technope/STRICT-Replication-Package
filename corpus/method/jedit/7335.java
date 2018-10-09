//}}}
//{{{ setLineHighlightColor() method
/**
	 * Sets the line highlight color.
	 * @param lineHighlightColor The line highlight color
	 */
public final void setLineHighlightColor(Color lineHighlightColor) {
    this.lineHighlightColor = lineHighlightColor;
    if (textArea.getBuffer() != null)
        textArea.invalidateLine(textArea.getCaretLine());
}