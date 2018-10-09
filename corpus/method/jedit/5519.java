//}}}
//{{{ _save() method
public void _save() {
    jEdit.setFontProperty("view.font", font.getFont());
    jEdit.setBooleanProperty("view.enableFontSubst", fontSubst.isSelected());
    fontSubstList.save();
    jEdit.setBooleanProperty("view.enableFontSubstSystemFonts", fontSubstSystemFonts.isSelected());
    jEdit.setColorProperty("view.fgColor", foregroundColor.getSelectedColor());
    jEdit.setColorProperty("view.bgColor", backgroundColor.getSelectedColor());
    jEdit.setBooleanProperty("view.caretBlink", blinkCaret.isSelected());
    jEdit.setBooleanProperty("view.blockCaret", blockCaret.isSelected());
    jEdit.setBooleanProperty("view.thickCaret", thickCaret.isSelected());
    jEdit.setColorProperty("view.caretColor", caretColor.getSelectedColor());
    jEdit.setColorProperty("view.selectionColor", selectionColor.getSelectedColor());
    jEdit.setColorProperty("view.multipleSelectionColor", multipleSelectionColor.getSelectedColor());
    jEdit.setBooleanProperty("view.selectionFg", selectionFg.isSelected());
    jEdit.setColorProperty("view.selectionFgColor", selectionFgColor.getSelectedColor());
    jEdit.setBooleanProperty("view.lineHighlight", lineHighlight.isSelected());
    jEdit.setColorProperty("view.lineHighlightColor", lineHighlightColor.getSelectedColor());
    jEdit.setBooleanProperty("view.structureHighlight", structureHighlight.isSelected());
    jEdit.setColorProperty("view.structureHighlightColor", structureHighlightColor.getSelectedColor());
    jEdit.setBooleanProperty("view.eolMarkers", eolMarkers.isSelected());
    jEdit.setColorProperty("view.eolMarkerColor", eolMarkerColor.getSelectedColor());
    jEdit.setBooleanProperty("view.wrapGuide", wrapGuide.isSelected());
    jEdit.setColorProperty("view.wrapGuideColor", wrapGuideColor.getSelectedColor());
    jEdit.setBooleanProperty("view.pageBreaks", pageBreaks.isSelected());
    jEdit.setColorProperty("view.pageBreaksColor", pageBreaksColor.getSelectedColor());
    jEdit.setIntegerProperty("view.electricBorders", electricBorders.isSelected() ? 3 : 0);
    AntiAlias nv = new AntiAlias(jEdit.getProperty("view.antiAlias"));
    nv.set(antiAlias.getSelectedIndex());
    jEdit.setProperty("view.antiAlias", nv.toString());
    jEdit.setBooleanProperty("view.fracFontMetrics", fracFontMetrics.isSelected());
    jEdit.setBooleanProperty("stripTrailingEOL", stripTrailingEOL.isSelected());
    jEdit.setBooleanProperty("completeFromAllBuffers", completeFromAllBuffers.isSelected());
    jEdit.setBooleanProperty("insertCompletionWithDigit", insertCompletionWithDigit.isSelected());
    jEdit.setIntegerProperty("options.textarea.lineSpacing", Integer.valueOf(lineSpacing.getText()));
}