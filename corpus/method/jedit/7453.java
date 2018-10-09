//{{{ View constructor
 View(Buffer buffer, ViewConfig config) {
    fullScreenMode = false;
    menuBar = null;
    plainView = config.plainView;
    enableEvents(AWTEvent.KEY_EVENT_MASK);
    // OS X users expect a preview of the window rather than an icon
    if (!OperatingSystem.isMacOS())
        setIconImage(GUIUtilities.getEditorIcon());
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    dockableWindowManager = getDockingFrameworkProvider().create(this, DockableWindowFactory.getInstance(), config);
    userTitle = config.title;
    dockableWindowManager.setMainPanel(mainPanel);
    topToolBars = new JPanel(new VariableGridLayout(VariableGridLayout.FIXED_NUM_COLUMNS, 1));
    bottomToolBars = new JPanel(new VariableGridLayout(VariableGridLayout.FIXED_NUM_COLUMNS, 1));
    toolBarManager = new ToolBarManager(topToolBars, bottomToolBars);
    status = new StatusBar(this);
    inputHandler = new DefaultInputHandler(this, (DefaultInputHandler) jEdit.getInputHandler());
    setSplitConfig(buffer, config.splitConfig);
    getContentPane().add(BorderLayout.CENTER, dockableWindowManager);
    dockableWindowManager.init();
    // tool bar and status bar gets added in propertiesChanged()
    // depending in the 'tool bar alternate layout' setting.
    propertiesChanged();
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowHandler());
    setFocusTraversalPolicy(new MyFocusTraversalPolicy());
    EditBus.addToBus(this);
    GUIUtilities.addSizeSaver(this, null, plainView ? "plain-view" : "view");
}