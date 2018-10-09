//{{{ HyperSearchResults constructor
public  HyperSearchResults(View view) {
    super(new BorderLayout());
    this.view = view;
    caption = new JLabel();
    Box toolBar = new Box(BoxLayout.X_AXIS);
    toolBar.add(caption);
    toolBar.add(Box.createGlue());
    ActionHandler ah = new ActionHandler();
    highlight = new RolloverButton();
    highlight.setToolTipText(jEdit.getProperty("hypersearch-results.highlight.label"));
    highlight.addActionListener(ah);
    toolBar.add(highlight);
    clear = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("hypersearch-results.clear.icon")));
    clear.setToolTipText(jEdit.getProperty("hypersearch-results.clear.label"));
    clear.addActionListener(ah);
    toolBar.add(clear);
    multi = new RolloverButton();
    multi.setToolTipText(jEdit.getProperty("hypersearch-results.multi.label"));
    multi.addActionListener(ah);
    toolBar.add(multi);
    stop = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("hypersearch-results.stop.icon")));
    stop.setToolTipText(jEdit.getProperty("hypersearch-results.stop.label"));
    stop.addActionListener(ah);
    toolBar.add(stop);
    stop.setEnabled(false);
    add(BorderLayout.NORTH, toolBar);
    resultTreeRoot = new DefaultMutableTreeNode();
    resultTreeModel = new DefaultTreeModel(resultTreeRoot);
    resultTree = new HighlightingTree(resultTreeModel);
    resultTree.setRowHeight(0);
    resultTree.setToolTipText(null);
    resultTree.setCellRenderer(new ResultCellRenderer());
    resultTree.setVisibleRowCount(16);
    resultTree.setRootVisible(false);
    resultTree.setShowsRootHandles(true);
    //the ESCAPE keystroke is assigned to hideTip action by swing
    //it breaks the action usually assigned to close-docking-area by jEdit,
    //so we remove this keystroke binding bug #1955140
    KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
    resultTree.getInputMap().remove(keyStroke);
    // looks bad with the OS X L&F, apparently...
    if (!OperatingSystem.isMacOSLF())
        resultTree.putClientProperty("JTree.lineStyle", "Angled");
    resultTree.setEditable(false);
    resultTree.addKeyListener(new KeyHandler());
    resultTree.addMouseListener(new MouseHandler());
    JScrollPane scrollPane = new JScrollPane(resultTree);
    Dimension dim = scrollPane.getPreferredSize();
    dim.width = 400;
    scrollPane.setPreferredSize(dim);
    add(BorderLayout.CENTER, scrollPane);
    resultTree.setTransferHandler(new ResultTreeTransferHandler());
}