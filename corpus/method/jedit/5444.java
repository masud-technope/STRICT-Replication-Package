//}}}
//{{{ _save() method
protected void _save() {
    jEdit.setFontProperty("print.font", font.getFont());
    jEdit.setBooleanProperty("print.header", printHeader.isSelected());
    jEdit.setBooleanProperty("print.footer", printFooter.isSelected());
    jEdit.setBooleanProperty("print.lineNumbers", printLineNumbers.isSelected());
    jEdit.setBooleanProperty("print.color", color.isSelected());
    jEdit.setProperty("print.tabSize", (String) tabSize.getSelectedItem());
    jEdit.setBooleanProperty("print.glyphVector", glyphVector.isSelected());
    jEdit.setBooleanProperty("print.force13", force13.isSelected());
    jEdit.setBooleanProperty("print.folds", printFolds.isSelected());
    jEdit.setBooleanProperty("print.useSystemDialog", useSystemDialog.isSelected());
}