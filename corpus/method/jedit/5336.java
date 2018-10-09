private JPanel createDockingOptionsPanel() {
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(0, 1));
    boolean autoLoadModeLayoutProp = jEdit.getBooleanProperty(AUTO_LOAD_MODE_LAYOUT_PROP, false);
    autoLoadModeLayout = new JCheckBox(jEdit.getProperty(AUTO_LOAD_MODE_LAYOUT_LABEL), autoLoadModeLayoutProp);
    p.add(autoLoadModeLayout);
    autoSaveModeLayout = new JCheckBox(jEdit.getProperty(AUTO_SAVE_MODE_LAYOUT_LABEL), jEdit.getBooleanProperty(AUTO_SAVE_MODE_LAYOUT_PROP, false));
    p.add(autoSaveModeLayout);
    autoSaveModeLayout.setEnabled(autoLoadModeLayoutProp);
    autoLoadModeLayout.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            autoSaveModeLayout.setEnabled(autoLoadModeLayout.isSelected());
        }
    });
    Box vSetSelection = Box.createVerticalBox();
    p.add(vSetSelection);
    Box setSelection = Box.createHorizontalBox();
    vSetSelection.add(setSelection);
    setSelection.add(Box.createHorizontalStrut(6));
    setSelection.add(new JLabel(jEdit.getProperty("options.docking.selectSet.label")));
    setSelection.add(Box.createHorizontalStrut(6));
    dockableSetSelection = new JComboBox<String>();
    setSelection.add(dockableSetSelection);
    dockableSetSelection.addItemListener(new ItemListener() {

        public void itemStateChanged(ItemEvent e) {
            windowModel.showSet((String) dockableSetSelection.getSelectedItem());
        }
    });
    setSelection.add(Box.createHorizontalStrut(6));
    vSetSelection.add(Box.createVerticalStrut(6));
    return p;
}