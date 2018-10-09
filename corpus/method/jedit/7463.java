//}}}
//{{{ propertiesChanged() method
/**
	 * Reloads various settings from the properties.
	 */
private void propertiesChanged() {
    JMenuBar mbar = GUIUtilities.loadMenuBar("view.mbar");
    // menu bar mnemonics take precedence over other shortcut definitions
    for (int i = 0; i < mbar.getMenuCount(); i++) {
        JMenu menu = mbar.getMenu(i);
        if (menu != null) {
            int mnemonic = menu.getMnemonic();
            if (mnemonic != 0) {
                Object keyBinding = inputHandler.getKeyBinding("A+" + Character.toLowerCase((char) mnemonic));
                if (keyBinding != null) {
                    menu.setMnemonic(0);
                }
            }
        }
    }
    setJMenuBar(mbar);
    loadToolBars();
    showFullPath = jEdit.getBooleanProperty("view.showFullPath");
    updateTitle();
    status.propertiesChanged();
    removeToolBar(status);
    getContentPane().remove(status);
    boolean showStatus = plainView ? jEdit.getBooleanProperty("view.status.plainview.visible") : jEdit.getBooleanProperty("view.status.visible");
    if (jEdit.getBooleanProperty("view.toolbar.alternateLayout")) {
        getContentPane().add(BorderLayout.NORTH, topToolBars);
        getContentPane().add(BorderLayout.SOUTH, bottomToolBars);
        if (showStatus)
            addToolBar(BOTTOM_GROUP, STATUS_BAR_LAYER, status);
    } else {
        mainPanel.add(topToolBars, BorderLayout.NORTH);
        mainPanel.add(bottomToolBars, BorderLayout.SOUTH);
        if (showStatus)
            getContentPane().add(BorderLayout.SOUTH, status);
    }
    updateBufferSwitcherStates();
    getRootPane().revalidate();
    if (fullScreenMode)
        updateFullScreenProps();
}