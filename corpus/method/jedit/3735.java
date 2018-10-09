public void open(DefaultListModel listModel) {
    final DefaultTableModel tableModel = createTableModel(listModel);
    final JTable table = new JTable(tableModel);
    // TODO: put this string in properties
    table.setToolTipText("Move: PgUp/PgDown; Edit: Double-Click or Insert/Delete");
    table.setRowHeight(GenericGUIUtilities.defaultRowHeight());
    table.getColumnModel().getColumn(0).setPreferredWidth(GenericGUIUtilities.defaultColumnWidth());
    table.addKeyListener(new KeyAdapter() {

        public void keyPressed(KeyEvent e) {
            int[] selRows = table.getSelectedRows();
            if (selRows.length == 0) {
                return;
            }
            int firstSelectedRow = selRows[0];
            int key = e.getKeyCode();
            ListSelectionModel selectionModel = table.getSelectionModel();
            switch(key) {
                case KeyEvent.VK_DELETE:
                    for (int i = selRows.length - 1; i >= 0; i--) {
                        tableModel.removeRow(selRows[i]);
                    }
                    if (firstSelectedRow >= 0 && firstSelectedRow < tableModel.getRowCount()) {
                        selectionModel.addSelectionInterval(firstSelectedRow, firstSelectedRow);
                    }
                    // avoid beep
                    e.consume();
                    break;
                case KeyEvent.VK_INSERT:
                    tableModel.insertRow(firstSelectedRow + 1, new String[] { "" });
                    // Dont edit cell
                    e.consume();
                    break;
                case KeyEvent.VK_PAGE_UP:
                case KeyEvent.VK_PAGE_DOWN:
                    boolean isUp = key == KeyEvent.VK_PAGE_UP;
                    int direction = isUp ? -1 : 1;
                    int min = selectionModel.getMinSelectionIndex() + direction;
                    int max = selectionModel.getMaxSelectionIndex() + direction;
                    if (min < 0 || max >= tableModel.getRowCount()) {
                        // avoid ArrayIndexOutOfBoundsException
                        return;
                    }
                    for (int i = 0; i < selRows.length; i++) {
                        int row = selRows[isUp ? i : (selRows.length - 1 - i)];
                        int to = row + direction;
                        selectionModel.removeSelectionInterval(row, row);
                        selectionModel.addSelectionInterval(to, to);
                        tableModel.moveRow(row, row, to);
                    }
                    break;
            }
        }
    });
    int result = JOptionPane.showConfirmDialog(null, table, "Change " + jEdit.getProperty("history.caption"), JOptionPane.OK_CANCEL_OPTION);
    if (result == JOptionPane.OK_OPTION) {
        updatelistModel(listModel, tableModel);
    }
}