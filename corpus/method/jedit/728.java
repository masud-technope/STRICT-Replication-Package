//{{{ BrowserView constructor
 BrowserView(final VFSBrowser browser) {
    this.browser = browser;
    tmpExpanded = new HashSet<String>();
    DockableWindowManager dwm = jEdit.getActiveView().getDockableWindowManager();
    KeyListener keyListener = dwm.closeListener(VFSBrowser.NAME);
    parentDirectories = new ParentDirectoryList();
    parentDirectories.addKeyListener(keyListener);
    parentDirectories.setName("parent");
    parentDirectories.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    parentDirectories.setCellRenderer(new ParentDirectoryRenderer());
    parentDirectories.setVisibleRowCount(5);
    parentDirectories.addMouseListener(new ParentMouseHandler());
    final JScrollPane parentScroller = new JScrollPane(parentDirectories);
    parentScroller.setMinimumSize(new Dimension(0, 0));
    table = new VFSDirectoryEntryTable(this);
    table.addMouseListener(new TableMouseHandler());
    table.addKeyListener(new TableKeyListener());
    table.setName("file");
    JScrollPane tableScroller = new JScrollPane(table);
    tableScroller.setMinimumSize(new Dimension(0, 0));
    tableScroller.getViewport().setBackground(table.getBackground());
    tableScroller.getViewport().addMouseListener(new TableMouseHandler());
    splitPane = new JSplitPane(browser.isHorizontalLayout() ? JSplitPane.HORIZONTAL_SPLIT : JSplitPane.VERTICAL_SPLIT, parentScroller, tableScroller);
    splitPane.setOneTouchExpandable(true);
    EventQueue.invokeLater(new Runnable() {

        public void run() {
            parentDirectories.ensureIndexIsVisible(parentDirectories.getModel().getSize());
        }
    });
    if (browser.isMultipleSelectionEnabled())
        table.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    else
        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    setLayout(new BorderLayout());
    add(BorderLayout.CENTER, splitPane);
    propertiesChanged();
}