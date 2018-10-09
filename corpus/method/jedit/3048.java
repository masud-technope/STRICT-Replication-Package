/**
	 * Initializes the pane's UI.
	 */
@Override
protected void _init() {
    setLayout(new BorderLayout());
    add(BorderLayout.NORTH, caption);
    listModel = new DefaultListModel<MenuItem>();
    reloadContextList(getContextMenu());
    list = new JList<MenuItem>(listModel);
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    list.addListSelectionListener(new ListHandler());
    add(BorderLayout.CENTER, new JScrollPane(list));
    buttons = new JPanel();
    buttons.setBorder(new EmptyBorder(3, 0, 0, 0));
    buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
    ActionHandler actionHandler = new ActionHandler();
    add = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("options.context.add.icon")));
    add.setToolTipText(jEdit.getProperty("common.add"));
    add.addActionListener(actionHandler);
    buttons.add(add);
    buttons.add(Box.createHorizontalStrut(6));
    remove = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("options.context.remove.icon")));
    remove.setToolTipText(jEdit.getProperty("common.remove"));
    remove.addActionListener(actionHandler);
    buttons.add(remove);
    buttons.add(Box.createHorizontalStrut(6));
    moveUp = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("options.context.moveUp.icon")));
    moveUp.setToolTipText(jEdit.getProperty("common.moveUp"));
    moveUp.addActionListener(actionHandler);
    buttons.add(moveUp);
    buttons.add(Box.createHorizontalStrut(6));
    moveDown = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("options.context.moveDown.icon")));
    moveDown.setToolTipText(jEdit.getProperty("common.moveDown"));
    moveDown.addActionListener(actionHandler);
    buttons.add(moveDown);
    buttons.add(Box.createGlue());
    // add "reset to defaults" button
    reset = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("options.context.reset.icon")));
    reset.setToolTipText(jEdit.getProperty("options.context.reset"));
    reset.addActionListener(actionHandler);
    buttons.add(reset);
    updateButtons();
    add(BorderLayout.SOUTH, buttons);
}