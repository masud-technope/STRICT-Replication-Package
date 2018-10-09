//}}}
//{{{ initGutter() method
private void initGutter() {
    Gutter gutter = getGutter();
    gutter.setExpanded(getBooleanProperty("view.gutter.lineNumbers"));
    int interval = getIntegerProperty("view.gutter.highlightInterval", 5);
    gutter.setHighlightInterval(interval);
    gutter.setCurrentLineHighlightEnabled(getBooleanProperty("view.gutter.highlightCurrentLine"));
    gutter.setStructureHighlightEnabled(getBooleanProperty("view.gutter.structureHighlight"));
    gutter.setStructureHighlightColor(getColorProperty("view.gutter.structureHighlightColor"));
    gutter.setBackground(getColorProperty("view.gutter.bgColor"));
    gutter.setForeground(getColorProperty("view.gutter.fgColor"));
    gutter.setHighlightedForeground(getColorProperty("view.gutter.highlightColor"));
    gutter.setFoldColor(getColorProperty("view.gutter.foldColor"));
    gutter.setCurrentLineForeground(getColorProperty("view.gutter.currentLineColor"));
    String alignment = getProperty("view.gutter.numberAlignment");
    if ("right".equals(alignment)) {
        gutter.setLineNumberAlignment(Gutter.RIGHT);
    } else if ("center".equals(alignment)) {
        gutter.setLineNumberAlignment(Gutter.CENTER);
    } else // left == default case
    {
        gutter.setLineNumberAlignment(Gutter.LEFT);
    }
    gutter.setFont(getFontProperty("view.gutter.font"));
    int width = getIntegerProperty("view.gutter.borderWidth", 3);
    gutter.setBorder(width, getColorProperty("view.gutter.focusBorderColor"), getColorProperty("view.gutter.noFocusBorderColor"), painter.getBackground());
}