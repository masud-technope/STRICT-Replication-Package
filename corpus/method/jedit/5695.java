//{{{ restoreSelection() method
/**
		 * Restore the selection.
		 *
		 * @param savedSelection the selection list that contains the jar names of the selected items
		 */
public void restoreSelection(List<String> savedSelection) {
    if (null != table) {
        table.setColumnSelectionInterval(0, 0);
        if (!savedSelection.isEmpty()) {
            int i = 0;
            int rowCount = getRowCount();
            for (; i < rowCount; i++) {
                if (savedSelection.contains(entries.get(i).jar)) {
                    table.setRowSelectionInterval(i, i);
                    break;
                }
            }
            ListSelectionModel lsm = table.getSelectionModel();
            for (; i < rowCount; i++) {
                if (savedSelection.contains(entries.get(i).jar)) {
                    lsm.addSelectionInterval(i, i);
                }
            }
        } else {
            if (table.getRowCount() != 0)
                table.setRowSelectionInterval(0, 0);
            JScrollBar scrollbar = scrollpane.getVerticalScrollBar();
            scrollbar.setValue(scrollbar.getMinimum());
        }
    }
//}}}
}