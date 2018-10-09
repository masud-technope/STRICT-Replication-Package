//}}}
//{{{ _init() method
@Override
protected void _init() {
    setLayout(new BorderLayout());
    mirrorLabel = new JLabel();
    updateMirrorLabel();
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
    JPanel spinnerPanel = null;
    if (jEdit.getSettingsDirectory() != null) {
        settingsDir = new JRadioButton(jEdit.getProperty("options.plugin-manager.settings-dir"));
        settingsDir.setToolTipText(MiscUtilities.constructPath(jEdit.getSettingsDirectory(), "jars"));
        int delay = jEdit.getIntegerProperty("plugin-manager.list-cache.minutes", 10);
        spinnerModel = new SpinnerNumberModel(delay, 0, 240, 5);
        cacheForSpinner = new JSpinner(spinnerModel);
        spinnerPanel = new JPanel();
        spinnerPanel.setLayout(new BoxLayout(spinnerPanel, BoxLayout.X_AXIS));
        spinnerPanel.add(new JLabel(jEdit.getProperty("options.plugin-manager.list-cache.minutes")));
        spinnerPanel.add(cacheForSpinner);
        spinnerPanel.add(Box.createGlue());
    }
    JRadioButton appDir = new JRadioButton(jEdit.getProperty("options.plugin-manager.app-dir"));
    appDir.setToolTipText(MiscUtilities.constructPath(jEdit.getJEditHome(), "jars"));
    miraList = new JList<String>(miraModel = new MirrorModel());
    miraList.setSelectionModel(new SingleSelectionModel());
    /* Download mirror */
    add(BorderLayout.NORTH, mirrorLabel);
    add(BorderLayout.CENTER, new JScrollPane(miraList));
    buttonPanel.add(Box.createVerticalStrut(6));
    /* Update mirror list */
    updateMirrors = new JButton(jEdit.getProperty("options.plugin-manager.updateMirrors"));
    updateMirrors.addActionListener(new ActionHandler());
    updateMirrors.setEnabled(false);
    ThreadUtilities.runInBackground(new UpdateMirrorsThread(false));
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    panel.add(updateMirrors);
    if (spinnerPanel != null)
        panel.add(spinnerPanel);
    panel.add(updateStatus);
    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
    buttonPanel.add(panel);
    buttonPanel.add(Box.createVerticalStrut(6));
    /* Download source */
    downloadSource = new JCheckBox(jEdit.getProperty("options.plugin-manager.downloadSource"));
    downloadSource.setSelected(jEdit.getBooleanProperty("plugin-manager.downloadSource"));
    downloadSource.setAlignmentX(Component.LEFT_ALIGNMENT);
    buttonPanel.add(downloadSource);
    /* Delete downloaded files */
    deleteDownloads = new JCheckBox(jEdit.getProperty("options.plugin-manager.deleteDownloads"));
    deleteDownloads.setSelected(jEdit.getBooleanProperty("plugin-manager.deleteDownloads"));
    deleteDownloads.setAlignmentX(Component.LEFT_ALIGNMENT);
    buttonPanel.add(deleteDownloads);
    /* Disable obsolete plugins */
    disableObsolete = new JCheckBox(jEdit.getProperty("options.plugin-manager.disable-obsolete"));
    disableObsolete.setSelected(jEdit.getBooleanProperty("plugin-manager.disable-obsolete", true));
    disableObsolete.setAlignmentX(Component.LEFT_ALIGNMENT);
    buttonPanel.add(disableObsolete);
    buttonPanel.add(Box.createVerticalStrut(6));
    /* Install location */
    ButtonGroup locGrp = new ButtonGroup();
    if (jEdit.getSettingsDirectory() != null)
        locGrp.add(settingsDir);
    locGrp.add(appDir);
    JPanel locPanel = new JPanel();
    locPanel.setLayout(new BoxLayout(locPanel, BoxLayout.Y_AXIS));
    if (jEdit.getSettingsDirectory() != null) {
        locPanel.add(settingsDir);
        locPanel.add(Box.createVerticalStrut(3));
    }
    locPanel.setBorder(new TitledBorder(jEdit.getProperty("options.plugin-manager.location")));
    locPanel.add(appDir);
    locPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    buttonPanel.add(locPanel);
    buttonPanel.add(Box.createGlue());
    add(BorderLayout.SOUTH, buttonPanel);
    if (jEdit.getBooleanProperty("plugin-manager.installUser") && jEdit.getSettingsDirectory() != null)
        settingsDir.setSelected(true);
    else
        appDir.setSelected(true);
}