//}}}
//{{{ _init() method
@Override
protected void _init() {
    setLayout(new BorderLayout());
    //{{{ North
    JPanel checkboxPanel = new JPanel(new GridLayout(2, 1));
    showStatusbar = new JCheckBox(jEdit.getProperty("options.status.visible"));
    showStatusbar.setSelected(jEdit.getBooleanProperty("view.status.visible"));
    checkboxPanel.add(showStatusbar);
    showStatusbarPlain = new JCheckBox(jEdit.getProperty("options.status.plainview.visible"));
    showStatusbarPlain.setSelected(jEdit.getBooleanProperty("view.status.plainview.visible"));
    checkboxPanel.add(showStatusbarPlain);
    checkboxPanel.add(new JLabel(jEdit.getProperty("options.status.caption")));
    JPanel previewPanel = new JPanel();
    previewStatusBar = new JLabel();
    previewPanel.add(previewStatusBar);
    JPanel north = new JPanel(new GridLayout(2, 1));
    north.add(checkboxPanel);
    north.add(previewPanel);
    add(north, BorderLayout.NORTH);
    //}}}
    //{{{ Options panel
    AbstractOptionPane optionsPanel = new AbstractOptionPane("Status Options");
    /* Foreground color */
    optionsPanel.addComponent(jEdit.getProperty("options.status.foreground"), foregroundColor = new ColorWellButton(jEdit.getColorProperty("view.status.foreground")), GridBagConstraints.VERTICAL);
    /* Background color */
    optionsPanel.addComponent(jEdit.getProperty("options.status.background"), backgroundColor = new ColorWellButton(jEdit.getColorProperty("view.status.background")), GridBagConstraints.VERTICAL);
    /* Memory foreground color */
    optionsPanel.addComponent(jEdit.getProperty("options.status.memory.foreground"), memForegroundColor = new ColorWellButton(jEdit.getColorProperty("view.status.memory.foreground")), GridBagConstraints.VERTICAL);
    /* Memory background color */
    optionsPanel.addComponent(jEdit.getProperty("options.status.memory.background"), memBackgroundColor = new ColorWellButton(jEdit.getColorProperty("view.status.memory.background")), GridBagConstraints.VERTICAL);
    optionsPanel.addSeparator();
    optionsPanel.addComponent(new JLabel(jEdit.getProperty("options.status.caret.title", "Caret position display options:")));
    /*
		Caret position format: lineno,dot-virtual (caretpos/bufferlength)
		view.status.show-caret-linenumber -- true shows line number for caret (lineno)
		view.status.show-caret-dot -- true shows offset in line for caret (dot)
		view.status.show-caret-virtual -- true shows virtual offset in line for caret (virtual)
		view.status.show-caret-offset -- true shows caret offset from start of buffer (caretpos)
		view.status.show-caret-bufferlength -- true shows length of buffer (bufferlength)
		*/
    showCaretLineNumber = new JCheckBox(jEdit.getProperty("options.status.caret.linenumber", "Show caret line number"), jEdit.getBooleanProperty("view.status.show-caret-linenumber", true));
    showCaretLineNumber.setName("showCaretLineNumber");
    showCaretDot = new JCheckBox(jEdit.getProperty("options.status.caret.dot", "Show caret offset from start of line"), jEdit.getBooleanProperty("view.status.show-caret-dot", true));
    showCaretDot.setName("showCaretDot");
    showCaretVirtual = new JCheckBox(jEdit.getProperty("options.status.caret.virtual", "Show caret virtual offset from start of line"), jEdit.getBooleanProperty("view.status.show-caret-virtual", true));
    showCaretVirtual.setName("showCaretVirtual");
    showCaretOffset = new JCheckBox(jEdit.getProperty("options.status.caret.offset", "Show caret offset from start of file"), jEdit.getBooleanProperty("view.status.show-caret-offset", true));
    showCaretOffset.setName("showCaretOffset");
    showCaretBufferLength = new JCheckBox(jEdit.getProperty("options.status.caret.bufferlength", "Show length of file"), jEdit.getBooleanProperty("view.status.show-caret-bufferlength", true));
    showCaretBufferLength.setName("showCaretBufferLength");
    optionsPanel.addComponent(showCaretLineNumber);
    optionsPanel.addComponent(showCaretDot);
    optionsPanel.addComponent(showCaretVirtual);
    optionsPanel.addComponent(showCaretOffset);
    optionsPanel.addComponent(showCaretBufferLength);
    //}}}
    //{{{ widgets panel
    String statusbar = jEdit.getProperty("view.status");
    StringTokenizer st = new StringTokenizer(statusbar);
    listModel = new DefaultListModel<String>();
    while (st.hasMoreTokens()) {
        String token = st.nextToken();
        listModel.addElement(token);
    }
    list = new JList<String>(listModel);
    list.setCellRenderer(new WidgetListCellRenderer());
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    list.addListSelectionListener(new ListHandler());
    JPanel widgetsPanel = new JPanel(new BorderLayout());
    widgetsPanel.add(new JScrollPane(list), BorderLayout.CENTER);
    //}}}
    //{{{ Create buttons
    JPanel buttons = new JPanel();
    buttons.setBorder(new EmptyBorder(3, 0, 0, 0));
    buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
    ActionHandler actionHandler = new ActionHandler();
    add = new RolloverButton(GUIUtilities.loadIcon("Plus.png"));
    add.setToolTipText(jEdit.getProperty("options.status.add"));
    add.addActionListener(actionHandler);
    buttons.add(add);
    buttons.add(Box.createHorizontalStrut(6));
    remove = new RolloverButton(GUIUtilities.loadIcon("Minus.png"));
    remove.setToolTipText(jEdit.getProperty("options.status.remove"));
    remove.addActionListener(actionHandler);
    buttons.add(remove);
    buttons.add(Box.createHorizontalStrut(6));
    moveUp = new RolloverButton(GUIUtilities.loadIcon("ArrowU.png"));
    moveUp.setToolTipText(jEdit.getProperty("options.status.moveUp"));
    moveUp.addActionListener(actionHandler);
    buttons.add(moveUp);
    buttons.add(Box.createHorizontalStrut(6));
    moveDown = new RolloverButton(GUIUtilities.loadIcon("ArrowD.png"));
    moveDown.setToolTipText(jEdit.getProperty("options.status.moveDown"));
    moveDown.addActionListener(actionHandler);
    buttons.add(moveDown);
    buttons.add(Box.createHorizontalStrut(6));
    edit = new RolloverButton(GUIUtilities.loadIcon("ButtonProperties.png"));
    edit.setToolTipText(jEdit.getProperty("options.status.edit"));
    edit.addActionListener(actionHandler);
    buttons.add(edit);
    buttons.add(Box.createGlue());
    //}}}
    updateButtons();
    widgetsPanel.add(buttons, BorderLayout.SOUTH);
    JTabbedPane tabs = new JTabbedPane();
    tabs.addTab("Options", optionsPanel);
    tabs.add("Widgets", widgetsPanel);
    add(tabs, BorderLayout.CENTER);
    updatePreview();
}