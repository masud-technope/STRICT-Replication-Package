//{{{ _init() method
@Override
protected void _init() {
    buffer = jEdit.getActiveView().getBuffer();
    String filename = buffer.getName();
    setName("Buffer: " + filename);
    addComponent(GUIUtilities.createMultilineLabel(jEdit.getProperty("buffer-options.caption")));
    addSeparator("buffer-options.loading-saving");
    //{{{ Line separator
    String[] lineSeps = { jEdit.getProperty("lineSep.unix"), jEdit.getProperty("lineSep.windows"), jEdit.getProperty("lineSep.mac") };
    lineSeparator = new JComboBox<String>(lineSeps);
    String lineSep = buffer.getStringProperty(JEditBuffer.LINESEP);
    if (lineSep == null)
        lineSep = System.getProperty("line.separator");
    if ("\n".equals(lineSep))
        lineSeparator.setSelectedIndex(0);
    else if ("\r\n".equals(lineSep))
        lineSeparator.setSelectedIndex(1);
    else if ("\r".equals(lineSep))
        lineSeparator.setSelectedIndex(2);
    addComponent(jEdit.getProperty("buffer-options.lineSeparator"), lineSeparator);
    //}}}
    //{{{ Encoding
    String[] encodings = MiscUtilities.getEncodings(true);
    Arrays.sort(encodings, new StandardUtilities.StringCompare<String>(true));
    encoding = new JComboBox<String>(encodings);
    encoding.setEditable(true);
    encoding.setSelectedItem(buffer.getStringProperty(JEditBuffer.ENCODING));
    addComponent(jEdit.getProperty("buffer-options.encoding"), encoding);
    //}}}
    //{{{ GZipped setting
    gzipped = new JCheckBox(jEdit.getProperty("buffer-options.gzipped"));
    gzipped.setSelected(buffer.getBooleanProperty(Buffer.GZIPPED));
    addComponent(gzipped);
    //}}}
    //{{{ Autoreload settings
    /* Check mod status on focus */
    String[] modCheckOptions = { jEdit.getProperty("options.general.checkModStatus.nothing"), jEdit.getProperty("options.general.checkModStatus.prompt"), jEdit.getProperty("options.general.checkModStatus.reload"), jEdit.getProperty("options.general.checkModStatus.silentReload") };
    checkModStatus = new JComboBox<String>(modCheckOptions);
    if (buffer.getAutoReload()) {
        if (buffer.getAutoReloadDialog())
            // reload and notify
            checkModStatus.setSelectedIndex(2);
        else
            // reload silently
            checkModStatus.setSelectedIndex(3);
    } else {
        if (buffer.getAutoReloadDialog())
            // prompt
            checkModStatus.setSelectedIndex(1);
        else
            // do nothing
            checkModStatus.setSelectedIndex(0);
    }
    addComponent(jEdit.getProperty("options.general.checkModStatus"), checkModStatus);
    // }}}
    addSeparator("buffer-options.editing");
    //{{{ Edit mode
    modes = jEdit.getModes();
    Arrays.sort(modes, new StandardUtilities.StringCompare<Mode>(true));
    mode = new JComboBox<Mode>(modes);
    mode.setSelectedItem(buffer.getMode());
    ActionHandler actionListener = new ActionHandler();
    mode.addActionListener(actionListener);
    addComponent(jEdit.getProperty("buffer-options.mode"), mode);
    //}}}
    //{{{ Fold mode
    String[] foldModes = FoldHandler.getFoldModes();
    folding = new JComboBox<String>(foldModes);
    folding.setSelectedItem(buffer.getStringProperty("folding"));
    addComponent(jEdit.getProperty("options.editing.folding"), folding);
    //}}}
    //{{{ Automatic indentation
    String[] indentModes = { "none", "simple", "full" };
    autoIndent = new JComboBox<String>(indentModes);
    autoIndent.setSelectedItem(buffer.getStringProperty("autoIndent"));
    addComponent(jEdit.getProperty("options.editing.autoIndent"), autoIndent);
    //}}}
    //{{{ Wrap mode
    String[] wrapModes = { "none", "soft", "hard" };
    wrap = new JComboBox<String>(wrapModes);
    wrap.setSelectedItem(buffer.getStringProperty("wrap"));
    addComponent(jEdit.getProperty("options.editing.wrap"), wrap);
    //}}}
    //{{{ Max line length
    String[] lineLengths = { "0", "72", "76", "80" };
    maxLineLen = new JComboBox<String>(lineLengths);
    maxLineLen.setEditable(true);
    maxLineLen.setSelectedItem(buffer.getStringProperty("maxLineLen"));
    addComponent(jEdit.getProperty("options.editing.maxLineLen"), maxLineLen);
    //}}}
    //{{{ Tab size
    String[] tabSizes = { "2", "4", "8" };
    tabSize = new JComboBox<String>(tabSizes);
    tabSize.setEditable(true);
    tabSize.setSelectedItem(buffer.getStringProperty("tabSize"));
    addComponent(jEdit.getProperty("options.editing.tabSize"), tabSize);
    //}}}
    //{{{ Indent size
    indentSize = new JComboBox<String>(tabSizes);
    indentSize.setEditable(true);
    indentSize.setSelectedItem(buffer.getStringProperty("indentSize"));
    addComponent(jEdit.getProperty("options.editing.indentSize"), indentSize);
    //}}}
    //{{{ Soft tabs
    noTabs = new JCheckBox(jEdit.getProperty("options.editing.noTabs"));
    noTabs.setSelected(buffer.getBooleanProperty("noTabs"));
    addComponent(noTabs);
    //}}}
    //{{{ Elastic tabstops
    elasticTabstops = new JCheckBox(jEdit.getProperty("options.editing.elasticTabstops"));
    elasticTabstops.setToolTipText(jEdit.getProperty("options.editing.elasticTabstops.tooltip"));
    elasticTabstops.setSelected(buffer.getBooleanProperty("elasticTabstops"));
    addComponent(elasticTabstops);
    //}}}
    //{{{ Locked setting
    locked = new JCheckBox(jEdit.getProperty("buffer-options.locked"));
    locked.setSelected(buffer.getBooleanProperty("locked"));
    addComponent(locked);
//}}}
}