public  jEditPanel() {
    super();
    /* Font */
    font = new FontSelector(jEdit.getFontProperty("print.font"));
    /* Header */
    printHeader = new JCheckBox(jEdit.getProperty("options.print.header"));
    printHeader.setSelected(jEdit.getBooleanProperty("print.header"));
    /* Footer */
    printFooter = new JCheckBox(jEdit.getProperty("options.print.footer"));
    printFooter.setSelected(jEdit.getBooleanProperty("print.footer"));
    /* Line numbering */
    printLineNumbers = new JCheckBox(jEdit.getProperty("options.print.lineNumbers"));
    printLineNumbers.setSelected(jEdit.getBooleanProperty("print.lineNumbers"));
    /* Tab size */
    String[] tabSizes = { "2", "4", "8" };
    tabSize = new JComboBox<String>(tabSizes);
    tabSize.setEditor(new NumericTextField("", true, true));
    tabSize.setEditable(true);
    tabSize.setSelectedItem(jEdit.getProperty("print.tabSize"));
    /* Print Folds */
    printFolds = new JCheckBox(jEdit.getProperty("options.print.folds"));
    printFolds.setSelected(jEdit.getBooleanProperty("print.folds", true));
    JPanel content = new JPanel(new VariableGridLayout(VariableGridLayout.FIXED_NUM_COLUMNS, 2, 6, 6));
    content.add(new JLabel(jEdit.getProperty("options.print.font")));
    content.add(font);
    content.add(new JLabel(jEdit.getProperty("options.print.tabSize")));
    content.add(tabSize);
    content.add(printHeader);
    content.add(Box.createGlue());
    content.add(printFooter);
    content.add(Box.createGlue());
    content.add(printLineNumbers);
    content.add(Box.createGlue());
    content.add(printFolds);
    content.add(Box.createGlue());
    add(content, BorderLayout.NORTH);
}