//}}}
//{{{ initPainter() method
/**
	 * Init the painter of a textarea.
	 *
	 * @param painter the painter of a textarea
	 * @since jEdit 4.3pre12
	 */
public static void initPainter(TextAreaPainter painter) {
    painter.setFont(jEdit.getFontProperty("view.font"));
    painter.setStructureHighlightEnabled(jEdit.getBooleanProperty("view.structureHighlight"));
    painter.setStructureHighlightColor(jEdit.getColorProperty("view.structureHighlightColor"));
    painter.setEOLMarkersPainted(jEdit.getBooleanProperty("view.eolMarkers"));
    painter.setEOLMarkerChar(jEdit.getProperty("view.eolMarkerChar", "·"));
    painter.setEOLMarkerColor(jEdit.getColorProperty("view.eolMarkerColor"));
    painter.setWrapGuidePainted(jEdit.getBooleanProperty("view.wrapGuide"));
    painter.setWrapGuideColor(jEdit.getColorProperty("view.wrapGuideColor"));
    painter.setCaretColor(jEdit.getColorProperty("view.caretColor"));
    painter.setSelectionColor(jEdit.getColorProperty("view.selectionColor"));
    painter.setMultipleSelectionColor(jEdit.getColorProperty("view.multipleSelectionColor"));
    painter.setBackground(jEdit.getColorProperty("view.bgColor"));
    painter.setForeground(jEdit.getColorProperty("view.fgColor"));
    painter.setBlockCaretEnabled(jEdit.getBooleanProperty("view.blockCaret"));
    painter.setThickCaretEnabled(jEdit.getBooleanProperty("view.thickCaret"));
    painter.setLineHighlightEnabled(jEdit.getBooleanProperty("view.lineHighlight"));
    painter.setLineHighlightColor(jEdit.getColorProperty("view.lineHighlightColor"));
    painter.setAntiAlias(new AntiAlias(jEdit.getProperty("view.antiAlias")));
    painter.setFractionalFontMetricsEnabled(jEdit.getBooleanProperty("view.fracFontMetrics"));
    painter.setSelectionFgColor(jEdit.getColorProperty("view.selectionFgColor"));
    painter.setSelectionFgColorEnabled(jEdit.getBooleanProperty("view.selectionFg"));
    String defaultFont = jEdit.getProperty("view.font");
    int defaultFontSize = jEdit.getIntegerProperty("view.fontsize", 12);
    painter.setStyles(SyntaxUtilities.loadStyles(defaultFont, defaultFontSize));
    SyntaxStyle[] foldLineStyle = new SyntaxStyle[4];
    for (int i = 0; i <= 3; i++) {
        foldLineStyle[i] = SyntaxUtilities.parseStyle(jEdit.getProperty("view.style.foldLine." + i), defaultFont, defaultFontSize, true);
    }
    painter.setFoldLineStyle(foldLineStyle);
}