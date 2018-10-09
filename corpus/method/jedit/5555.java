//}}}
//{{{ _init() method
@Override
protected void _init() {
    /* View dock layout */
    layoutIcon1 = GUIUtilities.loadIcon("dock_layout1.png");
    layoutIcon2 = GUIUtilities.loadIcon("dock_layout2.png");
    layoutIcon3 = GUIUtilities.loadIcon("dock_layout3.png");
    layoutIcon4 = GUIUtilities.loadIcon("dock_layout4.png");
    JPanel layoutPanel = new JPanel(new BorderLayout(12, 12));
    if (jEdit.getBooleanProperty("view.docking.alternateLayout")) {
        layout = new JLabel(jEdit.getBooleanProperty("view.toolbar.alternateLayout") ? layoutIcon4 : layoutIcon2);
    } else {
        layout = new JLabel(jEdit.getBooleanProperty("view.toolbar.alternateLayout") ? layoutIcon3 : layoutIcon1);
    }
    layout.setBorder(new EmptyBorder(12, 12, 12, 12));
    layoutPanel.add(BorderLayout.CENTER, layout);
    JPanel buttons = new JPanel(new GridLayout(2, 1, 12, 12));
    buttons.setBorder(new EmptyBorder(0, 12, 12, 12));
    buttons.add(alternateDockingLayout = new JButton(jEdit.getProperty("options.view.alternateDockingLayout")));
    ActionHandler actionHandler = new ActionHandler();
    alternateDockingLayout.addActionListener(actionHandler);
    buttons.add(alternateToolBarLayout = new JButton(jEdit.getProperty("options.view.alternateToolBarLayout")));
    alternateToolBarLayout.addActionListener(actionHandler);
    layoutPanel.add(BorderLayout.SOUTH, buttons);
    TitledBorder border = new TitledBorder(jEdit.getProperty("options.view.viewLayout"));
    border.setTitleJustification(TitledBorder.CENTER);
    layoutPanel.setBorder(border);
    addComponent(layoutPanel);
    /* Floatable Toolbars */
    floatableToolbars = new JCheckBox(jEdit.getProperty("options.view.floatableToolbars"));
    floatableToolbars.setSelected(jEdit.getBooleanProperty("view.toolbar.floatable"));
    addComponent(floatableToolbars);
    /* Abbreviate pathnames when possible */
    abbreviatePaths = new JCheckBox(jEdit.getProperty("options.view.abbreviatePaths"));
    abbreviatePaths.setSelected(jEdit.getBooleanProperty("view.abbreviatePaths"));
    addComponent(abbreviatePaths);
    /* Show full path */
    showFullPath = new JCheckBox(jEdit.getProperty("options.view.showFullPath"));
    showFullPath.setSelected(jEdit.getBooleanProperty("view.showFullPath"));
    addComponent(showFullPath);
    /* Show search bar */
    showSearchbar = new JCheckBox(jEdit.getProperty("options.view.showSearchbar"));
    showSearchbar.setSelected(jEdit.getBooleanProperty("view.showSearchbar"));
    addComponent(showSearchbar);
    /* Beep on search auto wrap */
    beepOnSearchAutoWrap = new JCheckBox(jEdit.getProperty("options.view.beepOnSearchAutoWrap"));
    beepOnSearchAutoWrap.setSelected(jEdit.getBooleanProperty("search.beepOnSearchAutoWrap"));
    addComponent(beepOnSearchAutoWrap);
    /* Show buffer switcher */
    addSeparator();
    showBufferSwitcher = new JCheckBox(jEdit.getProperty("options.view.showBufferSwitcher"));
    showBufferSwitcher.setSelected(jEdit.getBooleanProperty("view.showBufferSwitcher"));
    addComponent(showBufferSwitcher);
    showBufferSwitcher.addActionListener(actionHandler);
    /* Sort buffer switcher */
    sortBufferSwitcher = new JCheckBox(jEdit.getProperty("options.view.bufferswitcher.sortBuffers"));
    sortBufferSwitcher.setSelected(jEdit.getBooleanProperty("bufferswitcher.sortBuffers", true));
    sortBufferSwitcher.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
            sortBufferSwitcherByName.setEnabled(sortBufferSwitcher.isSelected());
        }
    });
    addComponent(sortBufferSwitcher);
    /* Sort buffer switcher by names */
    sortBufferSwitcherByName = new JCheckBox(jEdit.getProperty("options.view.bufferswitcher.sortByName"));
    sortBufferSwitcherByName.setSelected(jEdit.getBooleanProperty("bufferswitcher.sortByName", true));
    sortBufferSwitcherByName.setEnabled(sortBufferSwitcher.isSelected());
    addComponent(sortBufferSwitcherByName);
    /* Buffer switcher max row count */
    bufferSwitcherMaxRowCount = new JTextField(jEdit.getProperty("bufferSwitcher.maxRowCount"));
    addComponent(jEdit.getProperty("options.view.bufferSwitcherMaxRowsCount"), bufferSwitcherMaxRowCount);
    bufferSwitcherMaxRowCount.setEditable(showBufferSwitcher.isSelected());
    // Buffer set settings
    addSeparator();
    buffersetScope = new JComboBox<BufferSet.Scope>();
    buffersetScope.addItem(BufferSet.Scope.global);
    buffersetScope.addItem(BufferSet.Scope.view);
    buffersetScope.addItem(BufferSet.Scope.editpane);
    BufferSet.Scope scope;
    try {
        scope = BufferSet.Scope.valueOf(jEdit.getProperty("bufferset.scope", "global"));
    } catch (IllegalArgumentException e) {
        Log.log(Log.ERROR, this, e);
        scope = BufferSet.Scope.global;
    }
    buffersetScope.setSelectedItem(scope);
    addComponent(jEdit.getProperty("options.bufferset.scope"), buffersetScope);
    /* Sort buffers */
    sortBuffers = new JCheckBox(jEdit.getProperty("options.view.sortBuffers"));
    sortBuffers.setSelected(jEdit.getBooleanProperty("sortBuffers"));
    sortBuffers.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
            if (sortBuffers.isSelected()) {
                sortByName.setEnabled(true);
                sortBufferSwitcher.setEnabled(false);
                sortBufferSwitcher.setSelected(true);
                sortBufferSwitcherByName.setEnabled(false);
            } else {
                sortByName.setEnabled(false);
                sortBufferSwitcher.setEnabled(true);
                sortBufferSwitcherByName.setEnabled(true);
            }
        }
    });
    addComponent(sortBuffers);
    /* Sort buffers by names */
    sortByName = new JCheckBox(jEdit.getProperty("options.view.sortByName"));
    sortByName.setSelected(jEdit.getBooleanProperty("sortByName"));
    sortByName.setEnabled(sortBuffers.isSelected());
    addComponent(sortByName);
    addSeparator();
    fullScreenIncludesMenu = new JCheckBox(jEdit.getProperty("options.view.fullScreenIncludesMenu"));
    fullScreenIncludesMenu.setSelected(jEdit.getBooleanProperty("fullScreenIncludesMenu"));
    addComponent(fullScreenIncludesMenu);
    fullScreenIncludesToolbar = new JCheckBox(jEdit.getProperty("options.view.fullScreenIncludesToolbar"));
    fullScreenIncludesToolbar.setSelected(jEdit.getBooleanProperty("fullScreenIncludesToolbar"));
    addComponent(fullScreenIncludesToolbar);
    fullScreenIncludesStatus = new JCheckBox(jEdit.getProperty("options.view.fullScreenIncludesStatus"));
    fullScreenIncludesStatus.setSelected(jEdit.getBooleanProperty("fullScreenIncludesStatus"));
    addComponent(fullScreenIncludesStatus);
}