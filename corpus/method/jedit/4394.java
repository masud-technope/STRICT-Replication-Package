//{{{ HelpTOCPanel constructor
public  HelpTOCPanel(HelpViewerInterface helpViewer) {
    super(new BorderLayout());
    this.helpViewer = helpViewer;
    nodes = new HashMap<String, DefaultMutableTreeNode>();
    toc = new TOCTree();
    // looks bad with the OS X L&F, apparently...
    if (!OperatingSystem.isMacOSLF())
        toc.putClientProperty("JTree.lineStyle", "Angled");
    toc.setRowHeight(0);
    toc.setCellRenderer(new TOCCellRenderer());
    toc.setEditable(false);
    toc.setShowsRootHandles(true);
    add(BorderLayout.CENTER, new JScrollPane(toc));
    load();
}