//}}}
//{{{ getFoldLineStyle() method
/**
	 * Returns the fold line style. The first element is the style for
	 * lines with a fold level greater than 3. The remaining elements
	 * are for fold levels 1 to 3.
	 */
public final SyntaxStyle[] getFoldLineStyle() {
    return foldLineStyle;
}