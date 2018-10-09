//}}}
//{{{ _init() method
@Override
protected void _init() {
    allBindings = new Vector();
    setLayout(new BorderLayout(12, 12));
    KeymapManager keymapManager = jEdit.getKeymapManager();
    String keymapName = jEdit.getProperty("keymap.current");
    selectedKeymap = keymapManager.getKeymap(keymapName);
    if (selectedKeymap == null)
        selectedKeymap = keymapManager.getKeymap(KeymapManager.DEFAULT_KEYMAP_NAME);
    initModels();
    duplicateKeymap = new JButton(jEdit.getProperty("options.shortcuts.duplicatekeymap.label"));
    resetKeymap = new JButton(jEdit.getProperty("options.shortcuts.resetkeymap.label"));
    deleteKeymap = new JButton(jEdit.getProperty("options.shortcuts.deletekeymap.label"));
    resetButtons();
    ActionListener actionHandler = new ActionHandler();
    ComboBoxModel<String> model = new KeymapsModel();
    keymaps = new JComboBox(model);
    keymaps.setRenderer(new KeymapCellRenderer());
    keymaps.setSelectedItem(keymapName);
    duplicateKeymap.addActionListener(actionHandler);
    resetKeymap.addActionListener(actionHandler);
    deleteKeymap.addActionListener(actionHandler);
    keymaps.addActionListener(actionHandler);
    keymaps.setSelectedItem(selectedKeymap);
    JPanel keymapBox = new JPanel(new FlowLayout(FlowLayout.LEADING));
    keymapBox.add(new JLabel(jEdit.getProperty("options.shortcuts.keymap.label")));
    keymapBox.add(keymaps);
    keymapBox.add(Box.createHorizontalStrut(6));
    keymapBox.add(duplicateKeymap);
    keymapBox.add(resetKeymap);
    keymapBox.add(deleteKeymap);
    keymaps.setToolTipText(jEdit.getProperty("options.shortcuts.keymap.tooltip"));
    keymapBox.setToolTipText(jEdit.getProperty("options.shortcuts.keymap.tooltip"));
    // combobox to choose action set
    selectModel = new JComboBox(models);
    selectModel.addActionListener(actionHandler);
    selectModel.setToolTipText(jEdit.getProperty("options.shortcuts.select.tooltip"));
    Box north = Box.createHorizontalBox();
    north.add(new JLabel(jEdit.getProperty("options.shortcuts.select.label")));
    north.add(Box.createHorizontalStrut(6));
    north.add(selectModel);
    filterTF = new JTextField(40);
    filterTF.setToolTipText(jEdit.getProperty("options.shortcuts.filter.tooltip"));
    filterTF.getDocument().addDocumentListener(new DocumentListener() {

        @Override
        public void changedUpdate(DocumentEvent e) {
            setFilter();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            setFilter();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            setFilter();
        }
    });
    JButton clearButton = new JButton(jEdit.getProperty("options.shortcuts.clear.label"));
    clearButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            filterTF.setText("");
            filterTF.requestFocus();
        }
    });
    JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    filterPanel.add(new JLabel(jEdit.getProperty("options.shortcuts.filter.label")));
    filterPanel.add(filterTF);
    filterPanel.add(clearButton);
    keyTable = new JTable(filteredModel) {

        public String getToolTipText(MouseEvent e) {
            java.awt.Point p = e.getPoint();
            int rowIndex = rowAtPoint(p);
            int colIndex = columnAtPoint(p);
            int modelColIndex = convertColumnIndexToModel(colIndex);
            ShortcutsModel model = (ShortcutsModel) ((FilteredTableModel) getModel()).getDelegated();
            return modelColIndex == 0 ? model.getToolTip(rowIndex) : null;
        }
    };
    filteredModel.setTable(keyTable);
    keyTable.setRowHeight(GenericGUIUtilities.defaultRowHeight());
    keyTable.getTableHeader().setReorderingAllowed(false);
    keyTable.getTableHeader().addMouseListener(new HeaderMouseHandler());
    keyTable.addMouseListener(new TableMouseHandler());
    Dimension d = keyTable.getPreferredSize();
    d.height = Math.min(d.height, 200);
    JScrollPane scroller = new JScrollPane(keyTable);
    scroller.setPreferredSize(d);
    JPanel tableFilterPanel = new JPanel(new BorderLayout());
    tableFilterPanel.add(BorderLayout.NORTH, filterPanel);
    tableFilterPanel.add(BorderLayout.CENTER, scroller);
    Box northBox = Box.createVerticalBox();
    northBox.add(keymapBox);
    northBox.add(Box.createVerticalGlue());
    northBox.add(north);
    add(BorderLayout.NORTH, northBox);
    add(BorderLayout.CENTER, tableFilterPanel);
    try {
        selectModel.setSelectedIndex(jEdit.getIntegerProperty("options.shortcuts.select.index", 0));
    } catch (IllegalArgumentException eae) {
    }
}