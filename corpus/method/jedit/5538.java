//}}}
//{{{ _init() method
protected void _init() {
    setLayout(new BorderLayout());
    JPanel panel = new JPanel(new GridLayout(2, 1));
    /* Show toolbar */
    showToolbar = new JCheckBox(jEdit.getProperty("options.toolbar.showToolbar"));
    showToolbar.setSelected(jEdit.getBooleanProperty("view.showToolbar"));
    panel.add(showToolbar);
    panel.add(new JLabel(jEdit.getProperty("options.toolbar.caption")));
    add(BorderLayout.NORTH, panel);
    listModel = new DefaultListModel<ToolBarOptionPane.Button>();
    reloadButtonList(jEdit.getProperty("view.toolbar"));
    list = new JList<ToolBarOptionPane.Button>(listModel);
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    list.addListSelectionListener(new ListHandler());
    list.setCellRenderer(new ButtonCellRenderer());
    add(BorderLayout.CENTER, new JScrollPane(list));
    //{{{ Create buttons
    JPanel buttons = new JPanel();
    buttons.setBorder(new EmptyBorder(3, 0, 0, 0));
    buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
    ActionHandler actionHandler = new ActionHandler();
    add = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("options.toolbar.add.icon")));
    add.setToolTipText(jEdit.getProperty("options.toolbar.add"));
    add.addActionListener(actionHandler);
    buttons.add(add);
    buttons.add(Box.createHorizontalStrut(6));
    remove = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("options.toolbar.remove.icon")));
    remove.setToolTipText(jEdit.getProperty("options.toolbar.remove"));
    remove.addActionListener(actionHandler);
    buttons.add(remove);
    buttons.add(Box.createHorizontalStrut(6));
    moveUp = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("options.toolbar.moveUp.icon")));
    moveUp.setToolTipText(jEdit.getProperty("options.toolbar.moveUp"));
    moveUp.addActionListener(actionHandler);
    buttons.add(moveUp);
    buttons.add(Box.createHorizontalStrut(6));
    moveDown = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("options.toolbar.moveDown.icon")));
    moveDown.setToolTipText(jEdit.getProperty("options.toolbar.moveDown"));
    moveDown.addActionListener(actionHandler);
    buttons.add(moveDown);
    buttons.add(Box.createHorizontalStrut(6));
    edit = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("options.toolbar.edit.icon")));
    edit.setToolTipText(jEdit.getProperty("options.toolbar.edit"));
    edit.addActionListener(actionHandler);
    buttons.add(edit);
    buttons.add(Box.createGlue());
    // add "reset to defaults" button
    reset = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("options.toolbar.reset.icon")));
    reset.setToolTipText(jEdit.getProperty("options.toolbar.reset"));
    reset.addActionListener(actionHandler);
    buttons.add(reset);
    //}}}
    updateButtons();
    add(BorderLayout.SOUTH, buttons);
    //{{{ Ceate icons list
    iconList = new DefaultComboBoxModel<IconListEntry>();
    StringTokenizer st = new StringTokenizer(jEdit.getProperty("icons"));
    while (st.hasMoreElements()) {
        String icon = st.nextToken();
        iconList.addElement(new IconListEntry(GUIUtilities.loadIcon(icon), icon));
    //}}}
    }
}