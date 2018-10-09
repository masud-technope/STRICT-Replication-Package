private void reloadLists(Mode newMode) {
    // load the ping pong lists
    List<Mode> selectedModes = new ArrayList<Mode>();
    List<Mode> availableModes = new ArrayList<Mode>();
    Mode[] modes = loadAllModes();
    for (Mode mode : modes) {
        boolean selected = !jEdit.getBooleanProperty("mode.opt-out." + mode.getName(), false);
        if (selected) {
            selectedModes.add(mode);
        } else {
            availableModes.add(mode);
        }
    }
    pingPongList.setLeftData(availableModes);
    pingPongList.setRightData(selectedModes);
    if (newMode != null) {
        pingPongList.setRightSelected(newMode);
    }
    // reload the default mode combo box
    defaultMode.setModel(new DefaultComboBoxModel<Mode>(loadSelectedModes()));
    defaultMode.setSelectedItem(jEdit.getMode(jEdit.getProperty("buffer.defaultMode")));
}