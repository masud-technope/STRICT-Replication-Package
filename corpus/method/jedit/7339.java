//}}}
//{{{ setSelectionColor() method
/**
	 * Sets the selection color.
	 * @param selectionColor The selection color
	 */
public final void setSelectionColor(Color selectionColor) {
    this.selectionColor = selectionColor;
    textArea.repaint();
}