//}}}
//{{{ updateEnabled() method
private void updateEnabled() {
    int selectedRow = abbrevsTable.getSelectedRow();
    edit.setEnabled(selectedRow != -1);
    remove.setEnabled(selectedRow != -1);
}