//{{{ updateEnabled() method
private void updateEnabled() {
    int selectedRow = colorsTable.getSelectedRow();
    remove.setEnabled(selectedRow != -1);
    moveUp.setEnabled(selectedRow > 0);
    moveDown.setEnabled(selectedRow != -1 && selectedRow != colorsModel.getRowCount() - 1);
}