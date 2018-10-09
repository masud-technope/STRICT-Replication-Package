//}}}
//{{{ setFont() method
/**
	 * Sets the font for this component. This is overridden to update the
	 * cached font metrics and to recalculate which lines are visible.
	 * @param font The font
	 */
@Override
public void setFont(Font font) {
    super.setFont(font);
    fm = getFontMetrics(font);
    textArea.recalculateVisibleLines();
    if (textArea.getBuffer() != null && !textArea.getBuffer().isLoading())
        textArea.recalculateLastPhysicalLine();
//textArea.propertiesChanged();
}