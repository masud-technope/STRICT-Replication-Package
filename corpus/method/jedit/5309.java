//}}}
//{{{ setSelectedRow() method
private void setSelectedRow(int row) {
    colorsTable.getSelectionModel().setSelectionInterval(row, row);
    colorsTable.scrollRectToVisible(colorsTable.getCellRect(row, 0, true));
}