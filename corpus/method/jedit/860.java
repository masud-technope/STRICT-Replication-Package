//{{{ VFSDirectoryEntryTable constructor
 VFSDirectoryEntryTable(BrowserView browserView) {
    super(new VFSDirectoryEntryTableModel());
    this.browserView = browserView;
    setShowGrid(false);
    setIntercellSpacing(new Dimension(0, 0));
    setDefaultRenderer(Entry.class, renderer = new FileCellRenderer());
    header = getTableHeader();
    header.setReorderingAllowed(true);
    addMouseListener(new MainMouseHandler());
    header.addMouseListener(new MouseHandler());
    header.setDefaultRenderer(new HeaderRenderer((DefaultTableCellRenderer) header.getDefaultRenderer()));
    setRowSelectionAllowed(true);
    getColumnModel().addColumnModelListener(new ColumnHandler());
    setAutoResizeMode(AUTO_RESIZE_OFF);
}