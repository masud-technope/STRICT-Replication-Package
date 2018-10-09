/**
	 * Returns the value of a font property. The family is stored
	 * in the <code><i>name</i></code> property, the font size is stored
	 * in the <code><i>name</i>size</code> property, and the font style is
	 * stored in <code><i>name</i>style</code>. For example, if
	 * <code><i>name</i></code> is <code>view.gutter.font</code>, the
	 * properties will be named <code>view.gutter.font</code>,
	 * <code>view.gutter.fontsize</code>, and
	 * <code>view.gutter.fontstyle</code>.
	 *
	 * @param name The property
	 * @param def The default value
	 * @since jEdit 4.0pre1
	 */
private Font getFontProperty(String name, Font def) {
    String family = getProperty(name);
    String sizeString = getProperty(name + "size");
    String styleString = getProperty(name + "style");
    if (family == null || sizeString == null || styleString == null)
        return def;
    else {
        int size;
        try {
            size = Integer.parseInt(sizeString);
        } catch (NumberFormatException nf) {
            return def;
        }
        int style;
        try {
            style = Integer.parseInt(styleString);
        } catch (NumberFormatException nf) {
            return def;
        }
        return new Font(family, style, size);
    }
}