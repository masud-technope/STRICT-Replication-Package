@SuppressWarnings({ "unchecked" })
private void updatelistModel(DefaultListModel listModel, DefaultTableModel tableModel) {
    listModel.removeAllElements();
    for (int i = 0; i < tableModel.getRowCount(); i++) {
        Object cellText = tableModel.getValueAt(i, 0);
        if (cellText != null && !cellText.equals("")) {
            listModel.addElement(cellText);
        }
    }
}