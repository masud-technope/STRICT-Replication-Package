//}}}
//{{{ _save() method
public void _save() {
    jEdit.setBooleanProperty("view.gutter.lineNumbers", lineNumbersEnabled.isSelected());
    jEdit.setIntegerProperty("view.gutter.minDigitCount", Integer.valueOf(minLineNumberDigits.getText()));
    jEdit.setFontProperty("view.gutter.font", gutterFont.getFont());
    jEdit.setColorProperty("view.gutter.fgColor", gutterForeground.getSelectedColor());
    jEdit.setColorProperty("view.gutter.bgColor", gutterBackground.getSelectedColor());
    /* jEdit.setProperty("view.gutter.borderWidth",
			gutterBorderWidth.getText());

		String alignment = null;
		switch(gutterNumberAlignment.getSelectedIndex())
		{
		case 2:
			alignment = "right";
			break;
		case 1:
			alignment = "center";
			break;
		case 0: default:
			alignment = "left";
		}
		jEdit.setProperty("view.gutter.numberAlignment", alignment); */
    jEdit.setBooleanProperty("view.gutter.highlightCurrentLine", gutterCurrentLineHighlightEnabled.isSelected());
    jEdit.setColorProperty("view.gutter.currentLineColor", gutterCurrentLineHighlight.getSelectedColor());
    jEdit.setProperty("view.gutter.highlightInterval", gutterHighlightInterval.getText());
    jEdit.setColorProperty("view.gutter.highlightColor", gutterHighlightColor.getSelectedColor());
    jEdit.setBooleanProperty("view.gutter.structureHighlight", gutterStructureHighlightEnabled.isSelected());
    jEdit.setColorProperty("view.gutter.structureHighlightColor", gutterStructureHighlight.getSelectedColor());
    jEdit.setBooleanProperty("view.gutter.markerHighlight", gutterMarkerHighlightEnabled.isSelected());
    jEdit.setColorProperty("view.gutter.markerColor", gutterMarkerHighlight.getSelectedColor());
    jEdit.setColorProperty("view.gutter.foldColor", gutterFoldMarkers.getSelectedColor());
    jEdit.setProperty(JEditTextArea.FOLD_PAINTER_PROPERTY, painters[foldPainter.getSelectedIndex()]);
    jEdit.setColorProperty("view.gutter.focusBorderColor", gutterFocusBorder.getSelectedColor());
    jEdit.setColorProperty("view.gutter.noFocusBorderColor", gutterNoFocusBorder.getSelectedColor());
    jEdit.setBooleanProperty(GUTTER_ENABLED_PROPERTY, gutterEnabled.isSelected());
    jEdit.setBooleanProperty(SELECTION_AREA_ENABLED_PROPERTY, selectionAreaEnabled.isSelected());
    jEdit.setColorProperty(SELECTION_AREA_BGCOLOR_PROPERTY, selectionAreaBgColor.getSelectedColor());
    jEdit.setIntegerProperty("view.gutter.selectionAreaWidth", Integer.valueOf(selectionAreaWidth.getText()));
}