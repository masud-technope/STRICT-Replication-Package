/**
	 * Creates a new help viewer for the specified URL.
	 * @param url The URL
	 */
public  HelpViewer(String url) {
    super(jEdit.getProperty("helpviewer.title"));
    setIconImage(GUIUtilities.getEditorIcon());
    try {
        baseURL = new File(MiscUtilities.constructPath(jEdit.getJEditHome(), "doc")).toURI().toURL().toString();
    } catch (MalformedURLException mu) {
        Log.log(Log.ERROR, this, mu);
    }
    ActionHandler actionListener = new ActionHandler();
    JTabbedPane tabs = new JTabbedPane();
    tabs.addTab(jEdit.getProperty("helpviewer.toc.label"), toc = new HelpTOCPanel(this));
    tabs.addTab(jEdit.getProperty("helpviewer.search.label"), new HelpSearchPanel(this));
    tabs.setMinimumSize(new Dimension(0, 0));
    JPanel rightPanel = new JPanel(new BorderLayout());
    Box toolBar = new Box(BoxLayout.X_AXIS);
    //toolBar.setFloatable(false);
    toolBar.add(title = new JLabel());
    toolBar.add(Box.createGlue());
    historyModel = new HelpHistoryModel(25);
    back = new HistoryButton(HistoryButton.BACK, historyModel);
    back.addActionListener(actionListener);
    toolBar.add(back);
    forward = new HistoryButton(HistoryButton.FORWARD, historyModel);
    forward.addActionListener(actionListener);
    toolBar.add(forward);
    back.setPreferredSize(forward.getPreferredSize());
    rightPanel.add(BorderLayout.NORTH, toolBar);
    viewer = new JEditorPane();
    viewer.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
    viewer.setEditable(false);
    viewer.addHyperlinkListener(new LinkHandler());
    viewer.setFont(jEdit.getFontProperty("helpviewer.font"));
    viewer.addPropertyChangeListener(new PropertyChangeHandler());
    viewer.addKeyListener(new KeyHandler());
    viewer.addMouseListener(new MouseHandler());
    viewerScrollPane = new JScrollPane(viewer);
    rightPanel.add(BorderLayout.CENTER, viewerScrollPane);
    splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tabs, rightPanel);
    splitter.setBorder(null);
    getContentPane().add(BorderLayout.CENTER, splitter);
    historyModel.addHelpHistoryModelListener(this);
    historyUpdated();
    gotoURL(url, true, 0);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    getRootPane().setPreferredSize(new Dimension(750, 500));
    pack();
    GUIUtilities.loadGeometry(this, "helpviewer");
    GUIUtilities.addSizeSaver(this, "helpviewer");
    EditBus.addToBus(this);
    setVisible(true);
    EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            splitter.setDividerLocation(jEdit.getIntegerProperty("helpviewer.splitter", 250));
            viewer.requestFocus();
        }
    });
}