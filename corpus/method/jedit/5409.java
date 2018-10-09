//}}}
//{{{ _init() method
@Override
protected void _init() {
    Mode[] modes = reloadModes();
    mode = new JComboBox<String>(modeNames);
    mode.addActionListener(new ActionHandler());
    captionBox = new Box(BoxLayout.X_AXIS);
    addComponent(captionBox);
    addComponent(jEdit.getProperty("options.editing.mode"), mode);
    useDefaults = new JCheckBox(jEdit.getProperty("options.editing.useDefaults"));
    useDefaults.addActionListener(new ActionHandler());
    addComponent(useDefaults);
    addComponent(jEdit.getProperty("options.editing.noWordSep"), noWordSep = new JTextField());
    addComponent(camelCasedWords = new JCheckBox(jEdit.getProperty("options.editing.camelCasedWords")));
    String[] foldModes = FoldHandler.getFoldModes();
    addComponent(jEdit.getProperty("options.editing.folding"), folding = new JComboBox<String>(foldModes));
    addComponent(jEdit.getProperty("options.editing.collapseFolds"), collapseFolds = new JTextField());
    String[] wrapModes = { "none", "soft", "hard" };
    addComponent(jEdit.getProperty("options.editing.wrap"), wrap = new JComboBox<String>(wrapModes));
    String[] lineLens = { "0", "72", "76", "80" };
    maxLineLen = new JComboBox<String>(lineLens);
    maxLineLen.setToolTipText(jEdit.getProperty("options.editing.maxLineLen.tooltip"));
    addComponent(jEdit.getProperty("options.editing.maxLineLen"), maxLineLen);
    maxLineLen.setEditable(true);
    String[] indentModes = { "none", "simple", "full" };
    addComponent(jEdit.getProperty("options.editing.autoIndent"), autoIndent = new JComboBox<String>(indentModes));
    String[] tabSizes = { "2", "4", "8" };
    addComponent(jEdit.getProperty("options.editing.tabSize"), tabSize = new JComboBox<String>(tabSizes));
    tabSize.setEditable(true);
    addComponent(jEdit.getProperty("options.editing.indentSize"), indentSize = new JComboBox<String>(tabSizes));
    indentSize.setEditable(true);
    addComponent(noTabs = new JCheckBox(jEdit.getProperty("options.editing.noTabs")));
    addComponent(elasticTabstops = new JCheckBox(jEdit.getProperty("options.editing.elasticTabstops")));
    elasticTabstops.setToolTipText(jEdit.getProperty("options.editing.elasticTabstops.tooltip"));
    addComponent(deepIndent = new JCheckBox(jEdit.getProperty("options.editing.deepIndent")));
    filenameGlob = new JTextField();
    filenameGlob.setToolTipText(jEdit.getProperty("glob.tooltip"));
    addComponent(jEdit.getProperty("options.editing.filenameGlob"), filenameGlob);
    addComponent(jEdit.getProperty("options.editing.firstlineGlob"), firstlineGlob = new JTextField());
    selectMode();
}