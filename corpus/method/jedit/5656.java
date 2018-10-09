@Override
public void focusGained(FocusEvent fe) {
    if (-1 == table.getSelectedRow() && table.getRowCount() > 0) {
        table.setRowSelectionInterval(0, 0);
        JScrollBar scrollbar = scrollpane.getVerticalScrollBar();
        scrollbar.setValue(scrollbar.getMinimum());
    }
    if (-1 == table.getSelectedColumn()) {
        table.setColumnSelectionInterval(0, 0);
    }
}