public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == add) {
        colorsModel.add();
    } else if (source == remove) {
        int selectedRow = colorsTable.getSelectedRow();
        colorsModel.remove(selectedRow);
        updateEnabled();
    } else if (source == moveUp) {
        int selectedRow = colorsTable.getSelectedRow();
        if (selectedRow != 0) {
            colorsModel.moveUp(selectedRow);
            setSelectedRow(selectedRow - 1);
        }
        updateEnabled();
    } else if (source == moveDown) {
        int selectedRow = colorsTable.getSelectedRow();
        if (selectedRow != colorsTable.getRowCount() - 1) {
            colorsModel.moveDown(selectedRow);
            setSelectedRow(selectedRow + 1);
        }
        updateEnabled();
    }
}