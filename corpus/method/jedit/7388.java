//}}}
//{{{ setSelectionFgColor() method
/**
	 * Sets the selection foreground color.
	 * @param selectionFgColor The selection foreground color
	 * @since jEdit 4.4.1
	 */
public final void setSelectionFgColor(Color selectionFgColor) {
    this.selectionFgColor = selectionFgColor;
    if (isSelectionFgColorEnabled())
        textArea.repaint();
}