//}}}
//{{{ setStructureHighlightColor() method
/**
	 * Sets the structure highlight color.
	 * @param structureHighlightColor The structure highlight color
	 * @since jEdit 4.2pre3
	 */
public final void setStructureHighlightColor(Color structureHighlightColor) {
    this.structureHighlightColor = structureHighlightColor;
    repaint();
}