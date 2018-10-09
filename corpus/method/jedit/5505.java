//{{{ createStyleTableScroller() method
private JScrollPane createStyleTableScroller() {
    styleModel = createStyleTableModel();
    styleTable = new JTable(styleModel);
    styleTable.setRowHeight(GenericGUIUtilities.defaultRowHeight());
    styleTable.setRowSelectionAllowed(false);
    styleTable.setColumnSelectionAllowed(false);
    styleTable.setCellSelectionEnabled(false);
    styleTable.getTableHeader().setReorderingAllowed(false);
    styleTable.addMouseListener(new MouseHandler());
    TableColumnModel tcm = styleTable.getColumnModel();
    TableColumn styleColumn = tcm.getColumn(1);
    styleColumn.setCellRenderer(new StyleTableModel.StyleRenderer());
    Dimension d = styleTable.getPreferredSize();
    d.height = Math.min(d.height, 100);
    JScrollPane scroller = new JScrollPane(styleTable);
    scroller.setPreferredSize(d);
    return scroller;
}