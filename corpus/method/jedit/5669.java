//{{{ InstallPanel constructor
 InstallPanel(PluginManager window, boolean updates) {
    super(null);
    setLayout(layout = new CardLayout());
    this.window = window;
    this.updates = updates;
    setBorder(new EmptyBorder(12, 12, 12, 12));
    final JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    split.setResizeWeight(0.75);
    /* Setup the table */
    table = new JTable(pluginModel = new PluginTableModel());
    table.setShowGrid(false);
    table.setIntercellSpacing(new Dimension(0, 0));
    table.setRowHeight(GenericGUIUtilities.defaultRowHeight() + 2);
    table.setPreferredScrollableViewportSize(new Dimension(500, 200));
    table.setDefaultRenderer(Object.class, new TextRenderer((DefaultTableCellRenderer) table.getDefaultRenderer(Object.class)));
    table.addFocusListener(new TableFocusHandler());
    InputMap tableInputMap = table.getInputMap(JComponent.WHEN_FOCUSED);
    ActionMap tableActionMap = table.getActionMap();
    tableInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), "tabOutForward");
    tableActionMap.put("tabOutForward", new KeyboardAction(KeyboardCommand.TAB_OUT_FORWARD));
    tableInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, InputEvent.SHIFT_DOWN_MASK), "tabOutBack");
    tableActionMap.put("tabOutBack", new KeyboardAction(KeyboardCommand.TAB_OUT_BACK));
    tableInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "editPlugin");
    tableActionMap.put("editPlugin", new KeyboardAction(KeyboardCommand.EDIT_PLUGIN));
    tableInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "closePluginManager");
    tableActionMap.put("closePluginManager", new KeyboardAction(KeyboardCommand.CLOSE_PLUGIN_MANAGER));
    TableColumn col1 = table.getColumnModel().getColumn(0);
    TableColumn col2 = table.getColumnModel().getColumn(1);
    TableColumn col3 = table.getColumnModel().getColumn(2);
    TableColumn col4 = table.getColumnModel().getColumn(3);
    TableColumn col5 = table.getColumnModel().getColumn(4);
    col1.setPreferredWidth(30);
    col1.setMinWidth(30);
    col1.setMaxWidth(30);
    col1.setResizable(false);
    col2.setPreferredWidth(180);
    col3.setPreferredWidth(130);
    col4.setPreferredWidth(70);
    col5.setPreferredWidth(70);
    JTableHeader header = table.getTableHeader();
    header.setReorderingAllowed(false);
    header.addMouseListener(new HeaderMouseHandler());
    header.setDefaultRenderer(new HeaderRenderer((DefaultTableCellRenderer) header.getDefaultRenderer()));
    scrollpane = new JScrollPane(table);
    scrollpane.getViewport().setBackground(table.getBackground());
    split.setTopComponent(scrollpane);
    /* Create description */
    JScrollPane infoPane = new JScrollPane(infoBox = new PluginInfoBox());
    infoPane.setPreferredSize(new Dimension(500, 100));
    split.setBottomComponent(infoPane);
    EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            split.setDividerLocation(0.75);
        }
    });
    searchField = new JTextField();
    searchField.addKeyListener(new KeyAdapter() {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP) {
                table.dispatchEvent(e);
                table.requestFocus();
            }
        }
    });
    searchField.getDocument().addDocumentListener(new DocumentListener() {

        void update() {
            pluginModel.setFilterString(searchField.getText());
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            update();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            update();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            update();
        }
    });
    table.addKeyListener(new KeyAdapter() {

        @Override
        public void keyPressed(KeyEvent e) {
            int i = table.getSelectedRow(), n = table.getModel().getRowCount();
            if (e.getKeyChar() == '/' || e.getKeyCode() == KeyEvent.VK_DOWN && i == (n - 1) || e.getKeyCode() == KeyEvent.VK_UP && i == 0) {
                searchField.requestFocus();
                searchField.selectAll();
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (c != KeyEvent.CHAR_UNDEFINED && Character.isAlphabetic(c)) {
                searchField.dispatchEvent(e);
                searchField.requestFocus();
            }
        }
    });
    hideInstalled = !updates;
    final JCheckBox hideInstalledCB = new JCheckBox("Hide installed plugins", hideInstalled);
    hideInstalledCB.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            InstallPanel.this.hideInstalled = hideInstalledCB.isSelected();
            updateModel();
        }
    });
    hideInstalledCB.setAlignmentX(0);
    Box filterBox = Box.createHorizontalBox();
    filterBox.add(new JLabel("Filter : "));
    filterBox.add(searchField);
    filterBox.setAlignmentX(0);
    Box topBox = new Box(BoxLayout.PAGE_AXIS);
    topBox.add(filterBox);
    if (!updates) {
        topBox.add(hideInstalledCB);
    }
    /* Create buttons */
    Box buttons = new Box(BoxLayout.X_AXIS);
    buttons.add(new InstallButton());
    buttons.add(Box.createHorizontalStrut(12));
    buttons.add(new SelectallButton());
    buttons.add(chooseButton = new ChoosePluginSet());
    buttons.add(new ClearPluginSet());
    buttons.add(Box.createGlue());
    buttons.add(new SizeLabel());
    JPanel _installPanel = new JPanel(new BorderLayout(12, 12));
    _installPanel.add(BorderLayout.NORTH, topBox);
    _installPanel.add(BorderLayout.CENTER, split);
    _installPanel.add(BorderLayout.SOUTH, buttons);
    add(_installPanel, "INSTALL");
    JPanel loadingLabelPanel = new JPanel(new GridBagLayout());
    loadingLabelPanel.add(new JLabel("<html><b><strong>" + jEdit.getProperty("common.loading", "Loading...") + "</strong></b></html>"));
    add(loadingLabelPanel, "LOADING");
    JPanel noAvailablePluginsPanel = new JPanel(new GridBagLayout());
    noAvailablePluginsPanel.add(new JLabel("<html><b><strong>" + jEdit.getProperty("options.plugin-manager.no-plugin-available", "No available plugins...") + "</strong></b></html>"));
    add(noAvailablePluginsPanel, "NO_PLUGIN_AVAILABLE");
    JPanel pluginsAreUpToDatePanel = new JPanel(new GridBagLayout());
    pluginsAreUpToDatePanel.add(new JLabel("<html><b><strong>" + jEdit.getProperty("options.plugin-manager.no-plugin-uptodate", "Plugins are up to date...") + "</strong></b></html>"));
    add(pluginsAreUpToDatePanel, "PLUGIN_ARE_UP_TO_DATE");
    layout.show(this, "INSTALL");
    String path = jEdit.getProperty(PluginManager.PROPERTY_PLUGINSET, "");
    if (!path.isEmpty()) {
        loadPluginSet(path);
    }
}