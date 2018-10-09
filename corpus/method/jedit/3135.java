public  CloseDialog(View view, Collection<Buffer> buffers) {
    super(view, jEdit.getProperty("close.title"), true);
    this.view = view;
    JPanel content = new JPanel(new BorderLayout(12, 12));
    content.setBorder(new EmptyBorder(12, 12, 12, 12));
    setContentPane(content);
    Box iconBox = new Box(BoxLayout.Y_AXIS);
    iconBox.add(new JLabel(UIManager.getIcon("OptionPane.warningIcon")));
    iconBox.add(Box.createGlue());
    content.add(BorderLayout.WEST, iconBox);
    JPanel centerPanel = new JPanel(new BorderLayout());
    JLabel label = new JLabel(jEdit.getProperty("close.caption"));
    label.setBorder(new EmptyBorder(0, 0, 6, 0));
    centerPanel.add(BorderLayout.NORTH, label);
    bufferList = new JList<String>(bufferModel = new DefaultListModel<String>());
    bufferList.setVisibleRowCount(10);
    bufferList.addListSelectionListener(new ListHandler());
    boolean suppressNotSavedConfirmUntitled = jEdit.getBooleanProperty("suppressNotSavedConfirmUntitled");
    suppressNotSavedConfirmUntitled = suppressNotSavedConfirmUntitled || jEdit.getBooleanProperty("autosaveUntitled");
    for (Buffer buffer : buffers) {
        if (buffer.isDirty() && !(buffer.isUntitled() && suppressNotSavedConfirmUntitled))
            bufferModel.addElement(buffer.getPath());
    }
    centerPanel.add(BorderLayout.CENTER, new JScrollPane(bufferList));
    content.add(BorderLayout.CENTER, centerPanel);
    ActionHandler actionListener = new ActionHandler();
    Box buttons = new Box(BoxLayout.X_AXIS);
    buttons.add(Box.createGlue());
    buttons.add(selectAll = new JButton(jEdit.getProperty("close.selectAll")));
    selectAll.setMnemonic(jEdit.getProperty("close.selectAll.mnemonic").charAt(0));
    selectAll.addActionListener(actionListener);
    buttons.add(Box.createHorizontalStrut(6));
    buttons.add(save = new JButton(jEdit.getProperty("close.save")));
    save.setMnemonic(jEdit.getProperty("close.save.mnemonic").charAt(0));
    save.addActionListener(actionListener);
    buttons.add(Box.createHorizontalStrut(6));
    buttons.add(discard = new JButton(jEdit.getProperty("close.discard")));
    discard.setMnemonic(jEdit.getProperty("close.discard.mnemonic").charAt(0));
    discard.addActionListener(actionListener);
    buttons.add(Box.createHorizontalStrut(6));
    buttons.add(cancel = new JButton(jEdit.getProperty("common.cancel")));
    cancel.addActionListener(actionListener);
    buttons.add(Box.createGlue());
    bufferList.setSelectedIndex(0);
    content.add(BorderLayout.SOUTH, buttons);
    content.getRootPane().setDefaultButton(cancel);
    GenericGUIUtilities.requestFocus(this, bufferList);
    pack();
    setLocationRelativeTo(view);
    setVisible(true);
}