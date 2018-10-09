@Override
public void actionPerformed(ActionEvent evt) {
    if (isDownloadingList())
        return;
    boolean downloadSource = jEdit.getBooleanProperty("plugin-manager.downloadSource");
    boolean installUser = jEdit.getBooleanProperty("plugin-manager.installUser");
    Roster roster = new Roster();
    String installDirectory;
    if (installUser) {
        installDirectory = MiscUtilities.constructPath(jEdit.getSettingsDirectory(), "jars");
    } else {
        installDirectory = MiscUtilities.constructPath(jEdit.getJEditHome(), "jars");
    }
    int length = pluginModel.entries.size();
    int instcount = 0;
    for (int i = 0; i < length; i++) {
        Entry entry = (Entry) pluginModel.entries.get(i);
        if (entry.install) {
            entry.plugin.install(roster, installDirectory, downloadSource, !entry.checked);
            if (updates)
                entry.plugin.getCompatibleBranch().satisfyDependencies(roster, installDirectory, downloadSource);
            instcount++;
        }
    }
    if (roster.isEmpty())
        return;
    boolean cancel = false;
    if (updates && roster.getOperationCount() > instcount)
        if (GUIUtilities.confirm(window, "install-plugins.depend", null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.CANCEL_OPTION)
            cancel = true;
    if (!cancel) {
        new PluginManagerProgress(window, roster);
        roster.performOperationsInAWTThread(window);
        pluginModel.update();
    }
}