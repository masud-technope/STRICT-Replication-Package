public AttributeSet getAttributes() {
    jEdit.setFontProperty("print.font", font.getFont());
    jEdit.setBooleanProperty("print.header", printHeader.isSelected());
    jEdit.setBooleanProperty("print.footer", printFooter.isSelected());
    jEdit.setBooleanProperty("print.lineNumbers", printLineNumbers.isSelected());
    jEdit.setProperty("print.tabSize", (String) tabSize.getSelectedItem());
    jEdit.setBooleanProperty("print.folds", printFolds.isSelected());
    return null;
}