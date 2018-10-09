//}}}
//{{{ pluginListUpdated() method
private void pluginListUpdated() {
    Component selected = tabPane.getSelectedComponent();
    if (selected == installer || selected == updater) {
        installer.updateModel();
        updater.updateModel();
    }
    checkForObsoletePlugins();
}