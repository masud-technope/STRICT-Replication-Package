//}}}
//{{{ init() method
/**
	 * @param name the name of this pane
	 * @param pane - a sub-pane name to select (?)
	 * Could someone please write better docs for this function?
	 * Creates buttons, adds listeners, and makes the pane visible.
	 * This method is called automatically from the constructor,
	 *
	 * and also calls init on each of the optionPanes?
	 *
	 * @since jEdit 4.3pre9 (was private before)
	 */
protected void init(String name, String pane) {
    this.name = name;
    deferredOptionPanes = new HashMap<Object, OptionPane>();
    if (pane == null)
        pane = jEdit.getProperty(name + ".last");
    JPanel content = new JPanel(new BorderLayout(12, 12));
    content.setBorder(new EmptyBorder(12, 12, 12, 12));
    setContentPane(content);
    stage = new JScrollPane();
    paneTree = new JTree(createOptionTreeModel());
    paneTree.setRowHeight(0);
    paneTree.setVisibleRowCount(1);
    paneTree.setCellRenderer(new PaneNameRenderer());
    // looks bad with the OS X L&F, apparently...
    if (!OperatingSystem.isMacOSLF())
        paneTree.putClientProperty("JTree.lineStyle", "Angled");
    paneTree.setShowsRootHandles(true);
    paneTree.setRootVisible(false);
    JScrollPane scroller = new JScrollPane(paneTree, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scroller.setMinimumSize(new Dimension(100, 0));
    splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroller, stage);
    content.add(splitter, BorderLayout.CENTER);
    Box buttons = new Box(BoxLayout.X_AXIS);
    buttons.add(Box.createGlue());
    ok = new JButton(jEdit.getProperty("common.ok"));
    ok.addActionListener(this);
    buttons.add(ok);
    buttons.add(Box.createHorizontalStrut(6));
    getRootPane().setDefaultButton(ok);
    cancel = new JButton(jEdit.getProperty("common.cancel"));
    cancel.addActionListener(this);
    buttons.add(cancel);
    buttons.add(Box.createHorizontalStrut(6));
    apply = new JButton(jEdit.getProperty("common.apply"));
    apply.addActionListener(this);
    buttons.add(apply);
    buttons.add(Box.createGlue());
    content.add(buttons, BorderLayout.SOUTH);
    // register the Options dialog as a TreeSelectionListener.
    // this is done before the initial selection to ensure that the
    // first selected OptionPane is displayed on startup.
    paneTree.getSelectionModel().addTreeSelectionListener(this);
    OptionGroup rootNode = (OptionGroup) paneTree.getModel().getRoot();
    for (int i = 0; i < rootNode.getMemberCount(); i++) {
        paneTree.expandPath(new TreePath(new Object[] { rootNode, rootNode.getMember(i) }));
    }
    // param selects first option pane found
    if (!selectPane(rootNode, pane))
        selectPane(rootNode, null);
    splitter.setDividerLocation(paneTree.getPreferredSize().width + scroller.getVerticalScrollBar().getPreferredSize().width);
    GUIUtilities.loadGeometry(this, name);
    int dividerLocation = jEdit.getIntegerProperty(name + ".splitter", -1);
    if (dividerLocation != -1)
        splitter.setDividerLocation(dividerLocation);
    // in case saved geometry is too small
    updateSize();
    setVisible(true);
}