//{{{ ToolBarEditDialog constructor
public  ToolBarEditDialog(Component comp, DefaultComboBoxModel<ToolBarOptionPane.IconListEntry> iconListModel, ToolBarOptionPane.Button current) {
    super(GenericGUIUtilities.getParentDialog(comp), jEdit.getProperty("options.toolbar.edit.title"), true);
    JPanel content = new JPanel(new BorderLayout());
    content.setBorder(new EmptyBorder(12, 12, 12, 12));
    setContentPane(content);
    ActionHandler actionHandler = new ActionHandler();
    ButtonGroup grp = new ButtonGroup();
    JPanel typePanel = new JPanel(new GridLayout(3, 1, 6, 6));
    typePanel.setBorder(new EmptyBorder(0, 0, 6, 0));
    typePanel.add(new JLabel(jEdit.getProperty("options.toolbar.edit.caption")));
    separator = new JRadioButton(jEdit.getProperty("options.toolbar" + ".edit.separator"));
    separator.addActionListener(actionHandler);
    grp.add(separator);
    typePanel.add(separator);
    action = new JRadioButton(jEdit.getProperty("options.toolbar" + ".edit.action"));
    action.addActionListener(actionHandler);
    grp.add(action);
    typePanel.add(action);
    content.add(BorderLayout.NORTH, typePanel);
    JPanel actionPanel = new JPanel(new BorderLayout(6, 6));
    ActionSet[] actionsList = jEdit.getActionSets();
    String selectedActionSet = jEdit.getProperty("options.toolbar.selectedActionSet");
    ActionSet selectedItem = null;
    Vector<ActionSet> vec = new Vector<ActionSet>(actionsList.length);
    for (ActionSet actionSet : actionsList) {
        if (actionSet.getActionCount() != 0) {
            vec.add(actionSet);
            if (actionSet.getLabel().equals(selectedActionSet))
                selectedItem = actionSet;
        }
    }
    Collections.sort(vec, new ActionSetCompare());
    combo = new JComboBox<ActionSet>(vec);
    if (selectedItem != null)
        combo.setSelectedItem(selectedItem);
    else
        jEdit.unsetProperty("options.toolbar.selectedActionSet");
    combo.addActionListener(actionHandler);
    actionPanel.add(BorderLayout.NORTH, combo);
    list = new JList<ToolBarOptionPane.Button>();
    list.setVisibleRowCount(8);
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    actionPanel.add(BorderLayout.CENTER, new JScrollPane(list));
    // Icon selection
    JPanel iconPanel = new JPanel(new BorderLayout(0, 3));
    JPanel labelPanel = new JPanel(new GridLayout(2, 1));
    labelPanel.setBorder(new EmptyBorder(0, 0, 0, 12));
    JPanel compPanel = new JPanel(new GridLayout(2, 1));
    grp = new ButtonGroup();
    labelPanel.add(builtin = new JRadioButton(jEdit.getProperty("options.toolbar.edit.builtin")));
    builtin.addActionListener(actionHandler);
    grp.add(builtin);
    labelPanel.add(file = new JRadioButton(jEdit.getProperty("options.toolbar.edit.file")));
    grp.add(file);
    file.addActionListener(actionHandler);
    iconPanel.add(BorderLayout.WEST, labelPanel);
    builtinCombo = new JComboBox<ToolBarOptionPane.IconListEntry>(iconListModel);
    builtinCombo.setRenderer(new ToolBarOptionPane.IconCellRenderer());
    compPanel.add(builtinCombo);
    fileButton = new JButton(jEdit.getProperty("options.toolbar.edit.no-icon"));
    fileButton.setMargin(new Insets(1, 1, 1, 1));
    fileButton.setIcon(GUIUtilities.loadIcon("Blank24.gif"));
    fileButton.setHorizontalAlignment(SwingConstants.LEFT);
    fileButton.addActionListener(actionHandler);
    compPanel.add(fileButton);
    iconPanel.add(BorderLayout.CENTER, compPanel);
    actionPanel.add(BorderLayout.SOUTH, iconPanel);
    content.add(BorderLayout.CENTER, actionPanel);
    JPanel southPanel = new JPanel();
    southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
    southPanel.setBorder(new EmptyBorder(17, 0, 0, 0));
    ok = new JButton(jEdit.getProperty("common.ok"));
    ok.addActionListener(actionHandler);
    getRootPane().setDefaultButton(ok);
    cancel = new JButton(jEdit.getProperty("common.cancel"));
    cancel.addActionListener(actionHandler);
    GenericGUIUtilities.makeSameSize(ok, cancel);
    southPanel.add(Box.createGlue());
    southPanel.add(ok);
    southPanel.add(Box.createHorizontalStrut(6));
    southPanel.add(cancel);
    content.add(BorderLayout.SOUTH, southPanel);
    if (current == null) {
        action.setSelected(true);
        builtin.setSelected(true);
        updateList();
    } else {
        if (current.actionName.equals("-")) {
            separator.setSelected(true);
            builtin.setSelected(true);
        } else {
            action.setSelected(true);
            ActionSet set = jEdit.getActionSetForAction(current.actionName);
            combo.setSelectedItem(set);
            updateList();
            list.setSelectedValue(current, true);
            if (MiscUtilities.isURL(current.iconName)) {
                file.setSelected(true);
                fileIcon = current.iconName;
                try {
                    fileButton.setIcon(new ImageIcon(new URL(fileIcon)));
                } catch (MalformedURLException mf) {
                    Log.log(Log.ERROR, this, mf);
                }
                fileButton.setText(MiscUtilities.getFileName(fileIcon));
            } else {
                builtin.setSelected(true);
                ListModel model = builtinCombo.getModel();
                for (int i = 0; i < model.getSize(); i++) {
                    ToolBarOptionPane.IconListEntry entry = (ToolBarOptionPane.IconListEntry) model.getElementAt(i);
                    if (entry.name.equals(current.iconName)) {
                        builtinCombo.setSelectedIndex(i);
                        break;
                    }
                }
            }
        }
    }
    updateEnabled();
    pack();
    setLocationRelativeTo(GenericGUIUtilities.getParentDialog(comp));
    setVisible(true);
}