//}}}
//{{{ setLineNumberAlignment() method
/**
	 * Sets the horizontal alignment of the line numbers.
	 * @param alignment Gutter.RIGHT, Gutter.CENTER, Gutter.LEFT
	 */
public void setLineNumberAlignment(int alignment) {
    if (this.alignment == alignment)
        return;
    this.alignment = alignment;
    repaint();
}