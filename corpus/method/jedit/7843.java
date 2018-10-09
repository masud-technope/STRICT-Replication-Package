// }}}
// {{{ init() method
protected void _init() {
    setLayout(new BorderLayout());
    deferredOptionPanes = new HashMap<Object, OptionPane>();
    optionTreeModel = new OptionTreeModel();
    OptionGroup rootGroup = (OptionGroup) optionTreeModel.getRoot();
    // a label and only add its children
    for (Enumeration<Object> members = optionGroup.getMembers(); members.hasMoreElements(); ) {
        Object member = members.nextElement();
        if (member instanceof OptionGroup)
            rootGroup.addOptionGroup((OptionGroup) member);
        else if (member instanceof String)
            rootGroup.addOptionPane((String) member);
    // TODO are there any other cases that must handled?
    }
    paneTree = new JTree(optionTreeModel);
    paneTree.setRowHeight(0);
    paneTree.setRootVisible(false);
    paneTree.setCellRenderer(new PaneNameRenderer());
    JPanel content = new JPanel(new BorderLayout(12, 12));
    content.setBorder(new EmptyBorder(12, 12, 12, 12));
    add(content, BorderLayout.CENTER);
    stage = new JPanel(new BorderLayout());
    // looks bad with the OS X L&F, apparently...
    if (!OperatingSystem.isMacOSLF())
        paneTree.putClientProperty("JTree.lineStyle", "Angled");
    paneTree.setShowsRootHandles(true);
    paneTree.setRootVisible(false);
    JScrollPane scroller = new JScrollPane(paneTree, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scroller.setMinimumSize(new Dimension(120, 0));
    JScrollPane scroll = new JScrollPane(stage);
    scroll.getVerticalScrollBar().setUnitIncrement(10);
    splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroller, scroll);
    content.add(splitter, BorderLayout.CENTER);
    // register the Options dialog as a TreeSelectionListener.
    // this is done before the initial selection to ensure that the
    // first selected OptionPane is displayed on startup.
    paneTree.getSelectionModel().addTreeSelectionListener(this);
    OptionGroup rootNode = (OptionGroup) paneTree.getModel().getRoot();
    String name = optionGroup.getName();
    String pane = jEdit.getProperty(name + ".last");
    selectPane(rootNode, pane);
    paneTree.setVisibleRowCount(1);
    int dividerLocation = jEdit.getIntegerProperty(name + ".splitter", -1);
    if (dividerLocation != -1)
        splitter.setDividerLocation(dividerLocation);
    else
        splitter.setDividerLocation(paneTree.getPreferredSize().width + scroller.getVerticalScrollBar().getPreferredSize().width);
}