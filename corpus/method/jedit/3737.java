//{{{ LogViewer constructor
// The FilteredListModel needs work
@SuppressWarnings({ "unchecked" })
public  LogViewer() {
    super(new BorderLayout());
    setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 0));
    JPanel caption = new JPanel();
    caption.setLayout(new BoxLayout(caption, BoxLayout.X_AXIS));
    caption.setBorder(new EmptyBorder(6, 0, 6, 0));
    String settingsDirectory = jEdit.getSettingsDirectory();
    if (settingsDirectory != null) {
        String[] args = { MiscUtilities.constructPath(settingsDirectory, "activity.log") };
        JLabel label = new JLabel(jEdit.getProperty("log-viewer.caption", args));
        caption.add(label);
    }
    caption.add(Box.createHorizontalGlue());
    tailIsOn = jEdit.getBooleanProperty("log-viewer.tail", false);
    tail = new JCheckBox(jEdit.getProperty("log-viewer.tail.label"), tailIsOn);
    tail.addActionListener(new ActionHandler());
    filter = new JTextField();
    filter.getDocument().addDocumentListener(new DocumentListener() {

        @Override
        public void changedUpdate(DocumentEvent e) {
            setFilter();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            setFilter();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            setFilter();
        }
    });
    caption.add(filter);
    caption.add(tail);
    caption.add(Box.createHorizontalStrut(12));
    copy = new JButton(jEdit.getProperty("log-viewer.copy"));
    copy.addActionListener(new ActionHandler());
    caption.add(copy);
    caption.add(Box.createHorizontalStrut(6));
    JButton settings = new JButton(jEdit.getProperty("log-viewer.settings.label"));
    settings.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            new LogSettings();
        }
    });
    caption.add(settings);
    Log.setMaxLines(jEdit.getIntegerProperty("log-viewer.maxlines", 500));
    ListModel<String> model = Log.getLogListModel();
    listModel = new MyFilteredListModel(model);
    // without this, listModel is held permanently in model.
    // See addNotify() and removeNotify(), and constructor of
    // FilteredListModel.
    model.removeListDataListener(listModel);
    list = new LogList(listModel);
    listModel.setList(list);
    cellRenderer = new ColorizerCellRenderer(list);
    list.setCellRenderer(cellRenderer);
    setFilter();
    add(BorderLayout.NORTH, caption);
    JScrollPane scroller = new JScrollPane(list);
    Dimension dim = scroller.getPreferredSize();
    dim.width = Math.min(600, dim.width);
    scroller.setPreferredSize(dim);
    add(BorderLayout.CENTER, scroller);
    propertiesChanged();
}