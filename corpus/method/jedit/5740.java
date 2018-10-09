@Override
public void focusGained(FocusEvent fe) {
    if (table.getSelectedRow() == -1) {
        table.setRowSelectionInterval(0, 0);
        JScrollBar scrollbar = scrollpane.getVerticalScrollBar();
        scrollbar.setValue(scrollbar.getMinimum());
    }
    if (table.getSelectedColumn() == -1) {
        table.setColumnSelectionInterval(0, 0);
    }
}