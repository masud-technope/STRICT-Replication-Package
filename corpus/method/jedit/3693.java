//{{{ init() method
private void init() {
    dummy = new DummyRenderer();
    getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    setShowGrid(false);
    setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    TableColumn column = getColumnModel().getColumn(0);
    int checkBoxWidth = new JCheckBox().getPreferredSize().width;
    column.setPreferredWidth(checkBoxWidth);
    column.setMinWidth(checkBoxWidth);
    column.setWidth(checkBoxWidth);
    column.setMaxWidth(checkBoxWidth);
    column.setResizable(false);
    column = getColumnModel().getColumn(1);
    column.setCellRenderer(new LabelRenderer());
}