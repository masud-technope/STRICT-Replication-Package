//{{{ TaskMonitor constructor
public  TaskMonitor() {
    super(new BorderLayout());
    JPanel panel = new JPanel(new BorderLayout());
    remainingCount = new JLabel();
    panel.add(remainingCount, BorderLayout.NORTH);
    model = new TaskTableModel();
    model.addTableModelListener(new TableModelListener() {

        public void tableChanged(TableModelEvent e) {
            if (e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.DELETE) {
                updateTasksCount();
            }
        }
    });
    table = new JTable(model);
    table.setRowHeight(GenericGUIUtilities.defaultRowHeight());
    table.setDefaultRenderer(Object.class, new TaskCellRenderer());
    table.getTableHeader().setVisible(false);
    table.setDefaultEditor(Object.class, new TaskTableEditor());
    table.getColumnModel().getColumn(1).setMaxWidth(16);
    table.getColumnModel().getColumn(1).setMinWidth(16);
    JScrollPane scroll = new JScrollPane(table);
    panel.add(scroll);
    updateTasksCount();
    add(panel);
}