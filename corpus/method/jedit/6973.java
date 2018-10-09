//}}}
//{{{ initPainter() method
/**
	 * Init the painter of this textarea.
	 *
	 */
private void initPainter() {
    TextAreaPainter painter = getPainter();
    painter.setBlockCaretEnabled(false);
    painter.setFont(getFontProperty("view.font"));
    painter.setStructureHighlightEnabled(getBooleanProperty("view.structureHighlight"));
    painter.setStructureHighlightColor(getColorProperty("view.structureHighlightColor"));
    painter.setEOLMarkersPainted(getBooleanProperty("view.eolMarkers"));
    String emc = getProperty("view.eolMarkerChar");
    if (emc.length() > 0)
        painter.setEOLMarkerChar(emc);
    painter.setEOLMarkerColor(getColorProperty("view.eolMarkerColor"));
    painter.setWrapGuidePainted(getBooleanProperty("view.wrapGuide"));
    painter.setWrapGuideColor(getColorProperty("view.wrapGuideColor"));
    painter.setCaretColor(getColorProperty("view.caretColor"));
    painter.setSelectionColor(getColorProperty("view.selectionColor"));
    painter.setMultipleSelectionColor(getColorProperty("view.multipleSelectionColor"));
    painter.setBackground(getColorProperty("view.bgColor"));
    painter.setForeground(getColorProperty("view.fgColor"));
    painter.setBlockCaretEnabled(getBooleanProperty("view.blockCaret"));
    painter.setThickCaretEnabled(getBooleanProperty("view.thickCaret"));
    painter.setLineHighlightEnabled(getBooleanProperty("view.lineHighlight"));
    painter.setLineHighlightColor(getColorProperty("view.lineHighlightColor"));
    painter.setAntiAlias(new AntiAlias(getProperty("view.antiAlias")));
    painter.setFractionalFontMetricsEnabled(getBooleanProperty("view.fracFontMetrics"));
    painter.setSelectionFgColor(getColorProperty("view.selectionFgColor"));
    painter.setSelectionFgColorEnabled(getBooleanProperty("view.selectionFg"));
    String defaultFont = getProperty("view.font");
    int defaultFontSize = getIntegerProperty("view.fontsize", 12);
    painter.setStyles(SyntaxUtilities.loadStyles(defaultFont, defaultFontSize));
    SyntaxStyle[] foldLineStyle = new SyntaxStyle[4];
    for (int i = 0; i <= 3; i++) {
        foldLineStyle[i] = SyntaxUtilities.parseStyle(getProperty("view.style.foldLine." + i), defaultFont, defaultFontSize, true);
    }
    painter.setFoldLineStyle(foldLineStyle);
}