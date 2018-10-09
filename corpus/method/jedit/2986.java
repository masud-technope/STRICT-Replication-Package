//}}}
//{{{ propertiesChanged() method
private void propertiesChanged() {
    TextAreaPainter painter = textArea.getPainter();
    initPainter(painter);
    Gutter gutter = textArea.getGutter();
    gutter.setExpanded(jEdit.getBooleanProperty("view.gutter.lineNumbers"));
    int interval = jEdit.getIntegerProperty("view.gutter.highlightInterval", 5);
    gutter.setHighlightInterval(interval);
    gutter.setCurrentLineHighlightEnabled(jEdit.getBooleanProperty("view.gutter.highlightCurrentLine"));
    gutter.setStructureHighlightEnabled(jEdit.getBooleanProperty("view.gutter.structureHighlight"));
    gutter.setStructureHighlightColor(jEdit.getColorProperty("view.gutter.structureHighlightColor"));
    Color backgroundColor = jEdit.getColorProperty("view.gutter.bgColor");
    gutter.setBackground(backgroundColor);
    gutter.setForeground(jEdit.getColorProperty("view.gutter.fgColor"));
    gutter.setHighlightedForeground(jEdit.getColorProperty("view.gutter.highlightColor"));
    gutter.setFoldColor(jEdit.getColorProperty("view.gutter.foldColor"));
    markerHighlight.setMarkerHighlightColor(jEdit.getColorProperty("view.gutter.markerColor"));
    markerHighlight.setMarkerHighlightEnabled(jEdit.getBooleanProperty("view.gutter.markerHighlight"));
    gutter.setCurrentLineForeground(jEdit.getColorProperty("view.gutter.currentLineColor"));
    String alignment = jEdit.getProperty("view.gutter.numberAlignment");
    if ("right".equals(alignment)) {
        gutter.setLineNumberAlignment(Gutter.RIGHT);
    } else if ("center".equals(alignment)) {
        gutter.setLineNumberAlignment(Gutter.CENTER);
    } else // left == default case
    {
        gutter.setLineNumberAlignment(Gutter.LEFT);
    }
    gutter.setFont(jEdit.getFontProperty("view.gutter.font"));
    gutter.setGutterEnabled(GutterOptionPane.isGutterEnabled());
    gutter.setMinLineNumberDigitCount(GutterOptionPane.getMinLineNumberDigits());
    gutter.setSelectionAreaEnabled(GutterOptionPane.isSelectionAreaEnabled());
    gutter.setSelectionAreaBackground(GutterOptionPane.getSelectionAreaBackground());
    gutter.setSelectionAreaWidth(GutterOptionPane.getSelectionAreaWidth());
    int width = jEdit.getIntegerProperty("view.gutter.borderWidth", 3);
    gutter.setBorder(width, jEdit.getColorProperty("view.gutter.focusBorderColor"), jEdit.getColorProperty("view.gutter.noFocusBorderColor"), textArea.getPainter().getBackground());
    gutter.setFoldPainter(textArea.getFoldPainter());
    textArea.setCaretBlinkEnabled(jEdit.getBooleanProperty("view.caretBlink"));
    textArea.setElectricScroll(jEdit.getIntegerProperty("view.electricBorders", 0));
    // Set up the right-click popup menu
    textArea.createPopupMenu(null);
    // use old property name for backwards compatibility
    textArea.setQuickCopyEnabled(jEdit.getBooleanProperty("view.middleMousePaste"));
    textArea.setDragEnabled(jEdit.getBooleanProperty("view.dragAndDrop"));
    textArea.setJoinNonWordChars(jEdit.getBooleanProperty("view.joinNonWordChars"));
    textArea.setCtrlForRectangularSelection(jEdit.getBooleanProperty("view.ctrlForRectangularSelection"));
    textArea.setBackground(UIManager.getDefaults().getColor("ScrollBar.background"));
    textArea.propertiesChanged();
    if (bufferSwitcher != null) {
        bufferSwitcher.setMaximumRowCount(jEdit.getIntegerProperty("bufferSwitcher.maxRowCount", 10));
    }
}