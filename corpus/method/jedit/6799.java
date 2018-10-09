//}}}
//{{{ setFont() method
/*
	 * JComponent.setFont(Font) is overridden here to cache the font
	 * metrics for the font. This avoids having to get the font metrics
	 * during every repaint.
	 */
public void setFont(Font font) {
    super.setFont(font);
    fm = getFontMetrics(font);
    Border border = getBorder();
    if (border != null) {
        lineNumberWidth = fm.charWidth('5') * getLineNumberDigitCount();
        gutterSize.width = FOLD_MARKER_SIZE + border.getBorderInsets(this).right + lineNumberWidth;
        revalidate();
    }
}