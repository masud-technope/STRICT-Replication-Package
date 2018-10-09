public void stateChanged(ChangeEvent e) {
    Component selected = tabPane.getSelectedComponent();
    if (selected == installer || selected == updater) {
        updatePluginList();
    } else if (selected == manager)
        manager.update();
}