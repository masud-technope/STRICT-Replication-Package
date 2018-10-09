//}}}
//{{{ setMultipleSelectionColor() method
/**
	 * Sets the multiple selection color.
	 * @param multipleSelectionColor The multiple selection color
	 * @since jEdit 4.2pre1
	 */
public final void setMultipleSelectionColor(Color multipleSelectionColor) {
    this.multipleSelectionColor = multipleSelectionColor;
    textArea.repaint();
}