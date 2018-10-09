public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == mode) {
        saveMode();
        selectMode();
    } else if (source == useDefaults) {
        modeProps[mode.getSelectedIndex() - 1].useDefaults = useDefaults.isSelected();
        updateEnabled();
    }
}