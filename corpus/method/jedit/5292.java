//}}}
//{{{ _init() method
@Override
protected void _init() {
    /* Look and feel */
    //		addComponent(new JLabel(jEdit.getProperty("options.appearance.lf.note")));
    lfs = UIManager.getInstalledLookAndFeels();
    String[] names = new String[lfs.length];
    String lf = UIManager.getLookAndFeel().getClass().getName();
    int index = 0;
    for (int i = 0; i < names.length; i++) {
        names[i] = lfs[i].getName();
        if (lf.equals(lfs[i].getClassName()))
            index = i;
    }
    lookAndFeel = new JComboBox<String>(names);
    lookAndFeel.setSelectedIndex(index);
    lookAndFeel.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent evt) {
            updateEnabled();
        }
    });
    lookAndFeel.addItemListener(this);
    addComponent(jEdit.getProperty("options.appearance.lf"), lookAndFeel);
    /* Icon Theme */
    String[] themes = IconTheme.builtInNames();
    iconThemes = new JComboBox<String>(themes);
    addComponent(jEdit.getProperty("options.appearance.iconTheme"), iconThemes);
    String oldTheme = IconTheme.get();
    for (int i = 0; i < themes.length; ++i) {
        if (themes[i].equals(oldTheme)) {
            iconThemes.setSelectedIndex(i);
            break;
        }
    }
    /* Primary Metal L&F font */
    Font pf = jEdit.getFontProperty("metal.primary.font");
    primaryFont = new FontSelector(pf);
    addComponent(jEdit.getProperty("options.appearance.primaryFont"), primaryFont);
    /* Secondary Metal L&F font */
    secondaryFont = new FontSelector(jEdit.getFontProperty("metal.secondary.font"));
    addComponent(jEdit.getProperty("options.appearance.secondaryFont"), secondaryFont);
    /* HelpViewer font */
    helpViewerFont = new FontSelector(jEdit.getFontProperty("helpviewer.font", pf));
    addComponent(jEdit.getProperty("options.appearance.helpViewerFont"), helpViewerFont);
    /*
		antiAliasExtras = new JComboBox(AntiAlias.comboChoices);
		antiAliasExtras.setSelectedIndex(AntiAlias.appearance().val());
		antiAliasExtras.setToolTipText(jEdit.getProperty("options.textarea.antiAlias.tooltip"));
		addComponent(jEdit.getProperty("options.appearance.fonts.antialias"), antiAliasExtras);
		*/
    updateEnabled();
    /* History count */
    history = new NumericTextField(jEdit.getProperty("history"), true);
    addComponent(jEdit.getProperty("options.appearance.history"), history);
    /* Menu spillover count */
    menuSpillover = new NumericTextField(jEdit.getProperty("menu.spillover"), true);
    addComponent(jEdit.getProperty("options.appearance.menuSpillover"), menuSpillover);
    systemTrayIcon = new JCheckBox(jEdit.getProperty("options.general.systrayicon", "Show the systray icon"));
    systemTrayIcon.setSelected(jEdit.getBooleanProperty("systrayicon", true));
    addComponent(systemTrayIcon);
    addSeparator("options.appearance.startup.label");
    /* Show splash screen */
    showSplash = new JCheckBox(jEdit.getProperty("options.appearance.showSplash"));
    String settingsDirectory = jEdit.getSettingsDirectory();
    if (settingsDirectory == null)
        showSplash.setSelected(true);
    else
        showSplash.setSelected(!new File(settingsDirectory, "nosplash").exists());
    addComponent(showSplash);
    /* Show tip of the day */
    showTips = new JCheckBox(jEdit.getProperty("options.appearance.showTips"));
    showTips.setSelected(jEdit.getBooleanProperty("tip.show"));
    addComponent(showTips);
    addSeparator("options.appearance.experimental.label");
    addComponent(GUIUtilities.createMultilineLabel(jEdit.getProperty("options.appearance.experimental.caption")));
    /* Use jEdit colors in all text components */
    textColors = new JCheckBox(jEdit.getProperty("options.appearance.textColors"));
    textColors.setSelected(jEdit.getBooleanProperty("textColors"));
    addComponent(textColors);
    /* Decorate frames with look and feel (JDK 1.4 only) */
    decorateFrames = new JCheckBox(jEdit.getProperty("options.appearance.decorateFrames"));
    decorateFrames.setSelected(jEdit.getBooleanProperty("decorate.frames"));
    addComponent(decorateFrames);
    /* Decorate dialogs with look and feel (JDK 1.4 only) */
    decorateDialogs = new JCheckBox(jEdit.getProperty("options.appearance.decorateDialogs"));
    decorateDialogs.setSelected(jEdit.getBooleanProperty("decorate.dialogs"));
    addComponent(decorateDialogs);
    lnfChanged = false;
}