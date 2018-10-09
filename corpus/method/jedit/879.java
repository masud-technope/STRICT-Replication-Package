//}}}
//{{{ setSelectedRow() method
public void setSelectedRow(int row) {
    getSelectionModel().setSelectionInterval(row, row);
    scrollRectToVisible(getCellRect(row, 0, true));
}