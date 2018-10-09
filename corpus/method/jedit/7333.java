//}}}
//{{{ setLineHighlightEnabled() method
/**
	 * Enables or disables current line highlighting.
	 * @param lineHighlight True if current line highlight should be enabled,
	 * false otherwise
	 */
public final void setLineHighlightEnabled(boolean lineHighlight) {
    this.lineHighlight = lineHighlight;
    textArea.repaint();
}