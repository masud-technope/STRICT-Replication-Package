//}}}
//{{{ _init() method
@Override
protected void _init() {
    /* Save-As Uses FSB */
    saveAsUsesFSB = new JCheckBox(jEdit.getProperty("options.save-back.saveAsUsesFSB"));
    saveAsUsesFSB.setSelected(jEdit.getBooleanProperty("saveAsUsesFSB"));
    saveAsUsesFSB.setToolTipText(jEdit.getProperty("options.save-back.saveAsUsesFSB.tooltip"));
    addComponent(saveAsUsesFSB);
    /* Two-stage save */
    twoStageSave = new JCheckBox(jEdit.getProperty("options.save-back.twoStageSave"));
    twoStageSave.setSelected(jEdit.getBooleanProperty("twoStageSave"));
    twoStageSave.setToolTipText(jEdit.getProperty("options.save-back.twoStageSave.tooltip"));
    addComponent(twoStageSave);
    /* Confirm save all */
    confirmSaveAll = new JCheckBox(jEdit.getProperty("options.save-back.confirmSaveAll"));
    confirmSaveAll.setSelected(jEdit.getBooleanProperty("confirmSaveAll"));
    addComponent(confirmSaveAll);
    useMD5forDirtyCalculation = new JCheckBox(jEdit.getProperty("options.save-back.useMD5forDirtyCalculation"));
    useMD5forDirtyCalculation.setToolTipText(jEdit.getProperty("options.save-back.useMD5forDirtyCalculation.tooltip"));
    useMD5forDirtyCalculation.setSelected(jEdit.getBooleanProperty("useMD5forDirtyCalculation"));
    addComponent(useMD5forDirtyCalculation);
    /* Close Dirty Untitled Buffers without confirm */
    suppressNotSavedConfirmUntitled = new JCheckBox(jEdit.getProperty("options.save-back.suppressNotSavedConfirmUntitled"));
    suppressNotSavedConfirmUntitled.setToolTipText(jEdit.getProperty("options.save-back.suppressNotSavedConfirmUntitled.tooltip"));
    suppressNotSavedConfirmUntitled.setSelected(jEdit.getBooleanProperty("suppressNotSavedConfirmUntitled"));
    addComponent(suppressNotSavedConfirmUntitled);
    addSeparator("options.autosave");
    /* Autosave Directory */
    autosaveDirectory = new JTextField(jEdit.getProperty("autosave.directory"));
    autosaveDirectory.setToolTipText(jEdit.getProperty("options.save-back.backupDirectory.tooltip"));
    JButton browseAutosaveDirectory = new JButton("...");
    browseAutosaveDirectory.addActionListener(new MyActionListener2());
    JPanel panel = new JPanel(new BorderLayout());
    panel.add(autosaveDirectory);
    panel.add(browseAutosaveDirectory, BorderLayout.EAST);
    addComponent(jEdit.getProperty("options.save-back.autosaveDirectory"), panel);
    /* Autosave untitled buffers */
    autosaveUntitled = new JCheckBox(jEdit.getProperty("options.save-back.autosaveUntitled"));
    autosaveUntitled.setToolTipText(jEdit.getProperty("options.save-back.autosaveUntitled.tooltip"));
    autosaveUntitled.setSelected(jEdit.getBooleanProperty("autosaveUntitled"));
    addComponent(autosaveUntitled);
    /* Autosave interval */
    autosave = new NumericTextField(jEdit.getProperty("autosave"), true);
    autosave.setToolTipText(jEdit.getProperty("options.save-back.autosave.tooltip"));
    addComponent(jEdit.getProperty("options.save-back.autosave"), autosave);
    addSeparator("options.backup");
    /* Backup directory */
    backupDirectory = new JTextField(jEdit.getProperty("backup.directory"));
    backupDirectory.setToolTipText(jEdit.getProperty("options.save-back.backupDirectory.tooltip"));
    JButton browseBackupDirectory = new JButton("...");
    browseBackupDirectory.addActionListener(new MyActionListener());
    panel = new JPanel(new BorderLayout());
    panel.add(backupDirectory);
    panel.add(browseBackupDirectory, BorderLayout.EAST);
    addComponent(jEdit.getProperty("options.save-back.backupDirectory"), panel);
    /* Backup count */
    backups = new NumericTextField(jEdit.getProperty("backups"), true);
    backups.setToolTipText(jEdit.getProperty("options.save-back.backups.tooltip"));
    addComponent(jEdit.getProperty("options.save-back.backups"), backups);
    /* Backup filename prefix */
    backupPrefix = new JTextField(jEdit.getProperty("backup.prefix"));
    addComponent(jEdit.getProperty("options.save-back.backupPrefix"), backupPrefix);
    /* Backup suffix */
    backupSuffix = new JTextField(jEdit.getProperty("backup.suffix"));
    addComponent(jEdit.getProperty("options.save-back.backupSuffix"), backupSuffix);
    /* Backup on every save */
    backupEverySave = new JCheckBox(jEdit.getProperty("options.save-back.backupEverySave"));
    backupEverySave.setSelected(jEdit.getBooleanProperty("backupEverySave"));
    addComponent(backupEverySave);
}