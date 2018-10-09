private DefaultTableModel createTableModel(DefaultListModel listModel) {
    Object[][] tableRowData = new String[listModel.size()][1];
    for (int i = 0; i < listModel.size(); i++) {
        tableRowData[i][0] = listModel.get(i);
    }
    return new DefaultTableModel(tableRowData, new String[] { "" });
}