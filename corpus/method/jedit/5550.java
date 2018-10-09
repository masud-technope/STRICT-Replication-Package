//}}}
//{{{ updateEnabled() method
private void updateEnabled() {
    combo.setEnabled(action.isSelected());
    list.setEnabled(action.isSelected());
    boolean iconControlsEnabled = !separator.isSelected();
    builtin.setEnabled(iconControlsEnabled);
    file.setEnabled(iconControlsEnabled);
    builtinCombo.setEnabled(iconControlsEnabled && builtin.isSelected());
    fileButton.setEnabled(iconControlsEnabled && file.isSelected());
}