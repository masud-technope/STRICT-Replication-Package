//}}}
//{{{ setBorder() method
/*
	 * JComponent.setBorder(Border) is overridden here to cache the left
	 * inset of the border (if any) to avoid having to fetch it during every
	 * repaint.
	 */
public void setBorder(Border border) {
    super.setBorder(border);
    if (border == null) {
        collapsedSize.width = 0;
        collapsedSize.height = 0;
    } else {
        Insets insets = border.getBorderInsets(this);
        collapsedSize.width = FOLD_MARKER_SIZE + insets.right;
        if (isSelectionAreaEnabled())
            collapsedSize.width += selectionAreaWidth;
        collapsedSize.height = gutterSize.height = insets.top + insets.bottom;
        lineNumberWidth = fm.charWidth('5') * getLineNumberDigitCount();
        gutterSize.width = FOLD_MARKER_SIZE + insets.right + lineNumberWidth;
    }
    revalidate();
}