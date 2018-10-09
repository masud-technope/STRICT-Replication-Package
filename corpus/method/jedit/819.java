/**
	 * Creates a new VFS browser.
	 * @param view The view to open buffers in by default
	 * @param path The path to display
	 * @param mode The browser mode
	 * @param multipleSelection True if multiple selection should be allowed
	 * @param position Where the browser is located
	 * @since jEdit 4.2pre1
	 */
public  VFSBrowser(View view, String path, int mode, boolean multipleSelection, String position) {
    super(new BorderLayout());
    listenerList = new EventListenerList();
    this.mode = mode;
    this.multipleSelection = multipleSelection;
    this.view = view;
    currentEncoding = null;
    autoDetectEncoding = jEdit.getBooleanProperty("buffer.encodingAutodetect");
    ActionHandler actionHandler = new ActionHandler();
    topBox = new Box(BoxLayout.Y_AXIS);
    horizontalLayout = mode != BROWSER || DockableWindowManager.TOP.equals(position) || DockableWindowManager.BOTTOM.equals(position);
    toolbarBox = new Box(horizontalLayout ? BoxLayout.X_AXIS : BoxLayout.Y_AXIS);
    topBox.add(toolbarBox);
    GridBagLayout layout = new GridBagLayout();
    pathAndFilterPanel = new JPanel(layout);
    if (isHorizontalLayout())
        pathAndFilterPanel.setBorder(new EmptyBorder(12, 12, 12, 12));
    GridBagConstraints cons = new GridBagConstraints();
    cons.gridwidth = cons.gridheight = 1;
    cons.gridx = cons.gridy = 0;
    cons.fill = GridBagConstraints.BOTH;
    cons.anchor = GridBagConstraints.EAST;
    JLabel label = new JLabel(jEdit.getProperty("vfs.browser.path"), SwingConstants.RIGHT);
    label.setBorder(new EmptyBorder(0, 0, 0, 12));
    layout.setConstraints(label, cons);
    pathAndFilterPanel.add(label);
    pathField = new HistoryTextField("vfs.browser.path");
    pathField.setName("path");
    pathField.setInstantPopups(true);
    pathField.setEnterAddsToHistory(false);
    pathField.setSelectAllOnFocus(true);
    // because its preferred size can be quite wide, we
    // don't want it to make the browser way too big,
    // so set the preferred width to 0.
    Dimension prefSize = pathField.getPreferredSize();
    prefSize.width = 0;
    pathField.setPreferredSize(prefSize);
    pathField.addActionListener(actionHandler);
    cons.gridx = 1;
    cons.weightx = 1.0;
    cons.gridwidth = GridBagConstraints.REMAINDER;
    layout.setConstraints(pathField, cons);
    pathAndFilterPanel.add(pathField);
    filterCheckbox = new JCheckBox(jEdit.getProperty("vfs.browser.filter"));
    filterCheckbox.setMargin(new Insets(0, 0, 0, 0));
    //		filterCheckbox.setRequestFocusEnabled(false);
    filterCheckbox.setBorder(new EmptyBorder(0, 0, 0, 12));
    filterCheckbox.setSelected(jEdit.getBooleanProperty("vfs.browser.filter-enabled"));
    filterCheckbox.addActionListener(actionHandler);
    filterCheckbox.setName("filter-checkbox");
    if (mode != CHOOSE_DIRECTORY_DIALOG) {
        cons.gridwidth = 1;
        cons.gridx = 0;
        cons.weightx = 0.0;
        cons.gridy = 1;
        layout.setConstraints(filterCheckbox, cons);
        pathAndFilterPanel.add(filterCheckbox);
    }
    filterField = new JComboBox<VFSFileFilter>();
    filterEditor = new HistoryComboBoxEditor("vfs.browser.filter");
    filterEditor.setToolTipText(jEdit.getProperty("glob.tooltip"));
    filterEditor.setInstantPopups(true);
    filterEditor.setSelectAllOnFocus(true);
    filterEditor.addActionListener(actionHandler);
    filterField.setName("filter-field");
    if (mode == BROWSER) {
        DockableWindowManager dwm = view.getDockableWindowManager();
        KeyListener keyListener = dwm.closeListener(NAME);
        filterCheckbox.addKeyListener(keyListener);
        addKeyListener(keyListener);
        filterEditor.addKeyListener(keyListener);
        pathField.addKeyListener(keyListener);
        // save the location on close of dockable.
        pathField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    pathField.setText(VFSBrowser.this.path);
                }
            }
        });
    }
    String filter;
    if (mode == BROWSER || !jEdit.getBooleanProperty("vfs.browser.currentBufferFilter")) {
        filter = jEdit.getProperty("vfs.browser.last-filter");
        if (filter == null)
            filter = jEdit.getProperty("vfs.browser.default-filter");
    } else {
        String ext = MiscUtilities.getFileExtension(view.getBuffer().getName());
        if (ext.length() == 0)
            filter = jEdit.getProperty("vfs.browser.default-filter");
        else
            filter = '*' + ext;
    }
    // filterField.getEditor().setItem(new GlobVFSFileFilter(filter));
    // filterField.addItem(filterField.getEditor().getItem());
    filterEditor.setItem(new GlobVFSFileFilter(filter));
    filterField.addItem((VFSFileFilter) filterEditor.getItem());
    filterField.addItemListener(actionHandler);
    filterField.setRenderer(new VFSFileFilterRenderer());
    // loads the registered VFSFileFilter services.
    String[] _filters = ServiceManager.getServiceNames(VFSFileFilter.SERVICE_NAME);
    for (int i = 0; i < _filters.length; i++) {
        VFSFileFilter _filter = (VFSFileFilter) ServiceManager.getService(VFSFileFilter.SERVICE_NAME, _filters[i]);
        filterField.addItem(_filter);
    }
    if (mode != CHOOSE_DIRECTORY_DIALOG) {
        cons.gridwidth = GridBagConstraints.REMAINDER;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.weightx = 1.0;
        if (filterField.getItemCount() > 1) {
            filterField.setEditor(filterEditor);
            filterField.setEditable(true);
            layout.setConstraints(filterField, cons);
            pathAndFilterPanel.add(filterField);
        } else {
            layout.setConstraints(filterEditor, cons);
            pathAndFilterPanel.add(filterEditor);
        }
    }
    topBox.add(pathAndFilterPanel);
    add(BorderLayout.NORTH, topBox);
    add(BorderLayout.CENTER, browserView = new BrowserView(this));
    if (isHorizontalLayout())
        browserView.setBorder(new EmptyBorder(0, 12, 0, 12));
    defaultFocusComponent = browserView.getTable();
    propertiesChanged();
    updateFilterEnabled();
    setFocusTraversalPolicy(new LayoutFocusTraversalPolicy());
    // see VFSBrowser.browseDirectory()
    if (path == null)
        path = jEdit.getProperty("vfs.browser.path.tmp");
    if (path == null || path.isEmpty()) {
        String userHome = System.getProperty("user.home");
        String defaultPath = jEdit.getProperty("vfs.browser.defaultPath");
        if ("home".equals(defaultPath))
            path = userHome;
        else if ("working".equals(defaultPath))
            path = System.getProperty("user.dir");
        else if ("buffer".equals(defaultPath)) {
            Buffer buffer = view.getBuffer();
            boolean browseable = (buffer.getVFS().getCapabilities() & VFS.BROWSE_CAP) != 0;
            if (browseable)
                path = buffer.getDirectory();
        } else if ("last".equals(defaultPath)) {
            path = getLastVisitedPath();
            if (path == null)
                path = "~";
        } else if ("favorites".equals(defaultPath))
            path = "favorites:";
        if (path == null || path.isEmpty()) {
            // unknown value??!!!
            path = userHome;
        }
    }
    final String _path = path;
    ThreadUtilities.runInDispatchThread(new Runnable() {

        @Override
        public void run() {
            setDirectory(_path);
        }
    });
}