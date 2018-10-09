//}}}
//{{{ _init() method
@Override
protected void _init() {
    /* Check mod status */
    String[] modCheckOptions = { jEdit.getProperty("options.general.checkModStatus.nothing"), jEdit.getProperty("options.general.checkModStatus.prompt"), jEdit.getProperty("options.general.checkModStatus.reload"), jEdit.getProperty("options.general.checkModStatus.silentReload") };
    checkModStatus = new JComboBox<String>(modCheckOptions);
    if (jEdit.getBooleanProperty("autoReload")) {
        if (jEdit.getBooleanProperty("autoReloadDialog"))
            // reload and notify
            checkModStatus.setSelectedIndex(2);
        else
            // reload silently
            checkModStatus.setSelectedIndex(3);
    } else {
        if (jEdit.getBooleanProperty("autoReloadDialog"))
            // prompt
            checkModStatus.setSelectedIndex(1);
        else
            // do nothing
            checkModStatus.setSelectedIndex(0);
    }
    addComponent(jEdit.getProperty("options.general.checkModStatus"), checkModStatus);
    /* Check mod status upon */
    String[] modCheckUponOptions = { jEdit.getProperty("options.general.checkModStatusUpon.none"), jEdit.getProperty("options.general.checkModStatusUpon.focus"), jEdit.getProperty("options.general.checkModStatusUpon.visitBuffer"), jEdit.getProperty("options.general.checkModStatusUpon.all") };
    checkModStatusUpon = new JComboBox<String>(modCheckUponOptions);
    checkModStatusUpon.setSelectedIndex(jEdit.getIntegerProperty("checkFileStatus"));
    addComponent(jEdit.getProperty("options.general.checkModStatusUpon"), checkModStatusUpon);
    /* Recent file list size */
    {
        String recentFilesLabel = jEdit.getProperty("options.general.recentFiles");
        int recentFilesValue = jEdit.getIntegerProperty("recentFiles");
        SpinnerModel model = new SpinnerNumberModel(recentFilesValue, 0, Integer.MAX_VALUE, 1);
        recentFiles = new JSpinner(model);
        addComponent(recentFilesLabel, recentFiles);
    }
    /* Sort recent file list */
    sortRecent = new JCheckBox(jEdit.getProperty("options.general.sortRecent"));
    sortRecent.setSelected(jEdit.getBooleanProperty("sortRecent"));
    addComponent(sortRecent);
    /* Hide open buffers recent file list */
    hideOpen = new JCheckBox(jEdit.getProperty("options.general.hideOpen"));
    hideOpen.setSelected(jEdit.getBooleanProperty("hideOpen", true));
    addComponent(hideOpen);
    /* Close all confirmation */
    closeAllConfirm = new JCheckBox(jEdit.getProperty("options.general.closeAllConfirm"));
    closeAllConfirm.setSelected(jEdit.getBooleanProperty("closeAllConfirm", false));
    addComponent(closeAllConfirm);
    /* Save caret positions */
    saveCaret = new JCheckBox(jEdit.getProperty("options.general.saveCaret"));
    saveCaret.setSelected(jEdit.getBooleanProperty("saveCaret"));
    addComponent(saveCaret);
    /* Persistent markers */
    persistentMarkers = new JCheckBox(jEdit.getProperty("options.general.persistentMarkers"));
    persistentMarkers.setSelected(jEdit.getBooleanProperty("persistentMarkers"));
    addComponent(persistentMarkers);
    /* Session management */
    restore = new JCheckBox(jEdit.getProperty("options.general.restore"));
    restore.setSelected(jEdit.getBooleanProperty("restore"));
    restore.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent evt) {
            restoreCLI.setEnabled(restore.isSelected());
            restoreRemote.setEnabled(restore.isSelected());
        }
    });
    addComponent(restore);
    restoreRemote = new JCheckBox(jEdit.getProperty("options.general.restore.remote"));
    restoreRemote.setSelected(jEdit.getBooleanProperty("restore.remote", false));
    restoreRemote.setEnabled(restore.isSelected());
    addComponent(restoreRemote);
    restoreCLI = new JCheckBox(jEdit.getProperty("options.general.restore.cli"));
    restoreCLI.setSelected(jEdit.getBooleanProperty("restore.cli"));
    restoreCLI.setEnabled(restore.isSelected());
    addComponent(restoreCLI);
    restoreSplits = new JCheckBox(jEdit.getProperty("options.general.restore.splits", "Restore split configuration"));
    restoreSplits.setSelected(jEdit.getBooleanProperty("restore.splits", true));
    addComponent(restoreSplits);
    /* Maximum hypersearch results to ask for abort */
    {
        String maxWarnLabel = jEdit.getProperty("options.general.hypersearch.maxWarningResults");
        int maxWarnValue = jEdit.getIntegerProperty("hypersearch.maxWarningResults");
        SpinnerModel model = new SpinnerNumberModel(maxWarnValue, 0, Integer.MAX_VALUE, 1);
        hypersearchResultsWarning = new JSpinner(model);
        addComponent(maxWarnLabel, hypersearchResultsWarning);
    }
    String language = jEdit.getCurrentLanguage();
    String availableLanguages = jEdit.getProperty("available.lang", "en");
    String[] languages = availableLanguages.split(" ");
    useDefaultLocale = new JCheckBox(jEdit.getProperty("options.appearance.usedefaultlocale.label"));
    useDefaultLocale.setSelected(jEdit.getBooleanProperty("lang.usedefaultlocale"));
    useDefaultLocale.addChangeListener(new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e) {
            lang.setEnabled(!useDefaultLocale.isSelected());
        }
    });
    lang = new JComboBox<String>(languages);
    lang.setEnabled(!useDefaultLocale.isSelected());
    lang.setSelectedItem(language);
    lang.setRenderer(new LangCellRenderer());
    addSeparator("options.appearance.localization.section.label");
    addComponent(useDefaultLocale);
    addComponent(jEdit.getProperty("options.appearance.lang.label"), lang);
}