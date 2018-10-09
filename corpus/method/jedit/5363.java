//}}}
// {{{ _init() method
@Override
protected void _init() {
    Mode[] modes = loadAllModes();
    Mode[] userSelectedModes = loadSelectedModes();
    defaultMode = new JComboBox<Mode>(userSelectedModes);
    defaultMode.setSelectedItem(jEdit.getMode(jEdit.getProperty("buffer.defaultMode")));
    JPanel topPanel = new JPanel(new BorderLayout());
    topPanel.add(new JLabel(jEdit.getProperty("options.editing.defaultMode")), BorderLayout.WEST);
    topPanel.add(defaultMode);
    addComponent(topPanel);
    addSeparator();
    List<Mode> availableModes = new ArrayList<Mode>();
    List<Mode> selectedModes = new ArrayList<Mode>();
    for (Mode mode : modes) {
        String modeName = mode.getName();
        boolean selected = !jEdit.getBooleanProperty("mode.opt-out." + modeName, false);
        if (selected) {
            selectedModes.add(mode);
        } else {
            availableModes.add(mode);
        }
    }
    pingPongList = new PingPongList<Mode>(availableModes, selectedModes);
    pingPongList.setLeftTitle(jEdit.getProperty("options.editing.modes.available"));
    pingPongList.setRightTitle(jEdit.getProperty("options.editing.modes.selected"));
    pingPongList.setLeftTooltip(jEdit.getProperty("options.editing.modes.available.tooltip"));
    pingPongList.setRightTooltip(jEdit.getProperty("options.editing.modes.selected.tooltip"));
    pingPongList.setRightCellRenderer(new MyCellRenderer());
    pingPongList.addRightListSelectionListener(new MyListSelectionListener());
    deleteSelectedButton = new JButton(jEdit.getProperty("options.editing.modes.deleteSelected", "Delete Selected"));
    deleteSelectedButton.setEnabled(false);
    pingPongList.addButton(deleteSelectedButton);
    deleteSelectedButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            List<Mode> modes = pingPongList.getRightSelectedValues();
            StringBuilder sb = new StringBuilder();
            sb.append(jEdit.getProperty("options.editing.modes.Delete_these_modes?", "Delete these modes?")).append('\n');
            for (Mode m : modes) {
                if (m.isUserMode())
                    sb.append(m.getName()).append('\n');
            }
            int answer = JOptionPane.showConfirmDialog(jEdit.getActiveView(), sb.toString(), jEdit.getProperty("options.editing.deleteMode.dialog.title", "Confirm Mode Delete"), JOptionPane.WARNING_MESSAGE);
            if (answer == JOptionPane.YES_OPTION) {
                for (Mode m : modes) {
                    if (m.isUserMode()) {
                        try {
                            ModeProvider.instance.removeMode(m.getName());
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(jEdit.getActiveView(), jEdit.getProperty("options.editing.deleteMode.dialog.message1") + ' ' + m.getProperty("file") + '\n' + jEdit.getProperty("options.editing.deleteMode.dialog.message2") + ' ' + m.getName());
                        }
                    }
                }
                reloadLists(null);
            }
        }
    });
    addComponent(pingPongList, BOTH);
    addSeparator();
    // add mode panel
    addComponent(new JLabel(jEdit.getProperty("options.editing.addMode.dialog.title", "Add Mode")));
    JPanel content = new JPanel(new BorderLayout());
    content.setBorder(BorderFactory.createEmptyBorder(12, 12, 11, 11));
    addComponent(content);
    // main content
    AbstractOptionPane mainContent = new AbstractOptionPane("addmode");
    mainContent.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    modeName = new JTextField(36);
    mainContent.addComponent(jEdit.getProperty("options.editing.addMode.dialog.modeName"), modeName);
    modeFile = new JTextField();
    browse = new JButton("...");
    browse.addActionListener(new ActionHandler());
    JPanel browsePanel = new JPanel(new BorderLayout());
    browsePanel.add(modeFile, BorderLayout.CENTER);
    browsePanel.add(browse, BorderLayout.EAST);
    mainContent.addComponent(jEdit.getProperty("options.editing.addMode.dialog.modeFile"), browsePanel);
    filenameGlob = new JTextField(36);
    mainContent.addComponent(jEdit.getProperty("options.editing.addMode.dialog.filenameGlob"), filenameGlob);
    firstLineGlob = new JTextField(36);
    mainContent.addComponent(jEdit.getProperty("options.editing.addMode.dialog.firstLineGlob"), firstLineGlob);
    content.add(mainContent);
    // buttons
    JPanel buttons = new JPanel();
    buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
    buttons.setBorder(BorderFactory.createEmptyBorder(17, 0, 0, 6));
    ok = new JButton(jEdit.getProperty("options.editing.addMode", "Add Mode"));
    ok.addActionListener(new ActionHandler());
    buttons.add(Box.createGlue());
    buttons.add(ok);
    content.add(BorderLayout.SOUTH, buttons);
    addComponent(content);
}