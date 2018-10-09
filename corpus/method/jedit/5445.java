//}}}
//{{{ _init() method
protected void _init() {
    /* Font */
    font = new FontSelector(jEdit.getFontProperty("print.font"));
    addComponent(jEdit.getProperty("options.print.font"), font);
    /* Header */
    printHeader = new JCheckBox(jEdit.getProperty("options.print" + ".header"));
    printHeader.setSelected(jEdit.getBooleanProperty("print.header"));
    addComponent(printHeader);
    /* Footer */
    printFooter = new JCheckBox(jEdit.getProperty("options.print" + ".footer"));
    printFooter.setSelected(jEdit.getBooleanProperty("print.footer"));
    addComponent(printFooter);
    /* Line numbering */
    printLineNumbers = new JCheckBox(jEdit.getProperty("options.print" + ".lineNumbers"));
    printLineNumbers.setSelected(jEdit.getBooleanProperty("print.lineNumbers"));
    addComponent(printLineNumbers);
    /* Color */
    // NOTE: this is ignored when using BufferPrinter1_7 and BufferPrintable1_7.
    color = new JCheckBox(jEdit.getProperty("options.print" + ".color"));
    color.setSelected(jEdit.getBooleanProperty("print.color"));
    addComponent(color);
    /* Tab size */
    // DONE: make sure this can only accept positive numbers, added
    // NumericTextField as the combobox editor.
    String[] tabSizes = { "2", "4", "8" };
    tabSize = new JComboBox<String>(tabSizes);
    tabSize.setEditor(new NumericTextField("", true, true));
    tabSize.setEditable(true);
    tabSize.setSelectedItem(jEdit.getProperty("print.tabSize"));
    addComponent(jEdit.getProperty("options.print.tabSize"), tabSize);
    /* Print Folds */
    printFolds = new JCheckBox(jEdit.getProperty("options.print" + ".folds"));
    printFolds.setSelected(jEdit.getBooleanProperty("print.folds", true));
    addComponent(printFolds);
    addSeparator("options.print.workarounds");
    /* Spacing workaround */
    glyphVector = new JCheckBox(jEdit.getProperty("options.print.glyphVector"));
    glyphVector.setSelected(jEdit.getBooleanProperty("print.glyphVector", true));
    addComponent(glyphVector);
    /* Force 1.3 print dialog */
    force13 = new JCheckBox(jEdit.getProperty("options.print.force13"));
    force13.setSelected(jEdit.getBooleanProperty("print.force13"));
    addComponent(force13);
    useSystemDialog = new JCheckBox(jEdit.getProperty("options.print.useSystemDialog"));
    useSystemDialog.setSelected(jEdit.getBooleanProperty("print.useSystemDialog", false));
    addComponent(useSystemDialog);
}