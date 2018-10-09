//{{{ createWindowTableScroller() method
private JScrollPane createWindowTableScroller() {
    windowModel = createWindowModel();
    JTable windowTable = new JTable(windowModel);
    windowTable.getTableHeader().setReorderingAllowed(false);
    windowTable.setColumnSelectionAllowed(false);
    windowTable.setRowSelectionAllowed(false);
    windowTable.setCellSelectionEnabled(false);
    DockPositionCellRenderer comboBox = new DockPositionCellRenderer();
    windowTable.setRowHeight(comboBox.getPreferredSize().height);
    TableColumn column = windowTable.getColumnModel().getColumn(1);
    column.setCellRenderer(comboBox);
    column.setCellEditor(new DefaultCellEditor(new DockPositionCellRenderer()));
    Dimension d = windowTable.getPreferredSize();
    d.height = Math.min(d.height, 50);
    JScrollPane scroller = new JScrollPane(windowTable);
    scroller.setPreferredSize(d);
    return scroller;
}