//}}}
//{{{ setFoldLineStyle() method
/**
	 * Sets the fold line style. The first element is the style for
	 * lines with a fold level greater than 3. The remaining elements
	 * are for fold levels 1 to 3.
	 * @param foldLineStyle The fold line style
	 */
public final void setFoldLineStyle(SyntaxStyle[] foldLineStyle) {
    this.foldLineStyle = foldLineStyle;
    textArea.chunkCache.reset();
    repaint();
}