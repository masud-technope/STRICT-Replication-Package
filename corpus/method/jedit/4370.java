//{{{ HelpSearchPanel constructor
public  HelpSearchPanel(HelpViewerInterface helpViewer) {
    super(new BorderLayout(6, 6));
    this.helpViewer = helpViewer;
    Box box = new Box(BoxLayout.X_AXIS);
    box.add(new JLabel(jEdit.getProperty("helpviewer.search.caption")));
    box.add(Box.createHorizontalStrut(6));
    box.add(searchField = new HistoryTextField("helpviewer.search"));
    searchField.addActionListener(new ActionHandler());
    add(BorderLayout.NORTH, box);
    results = new JList<Result>();
    results.addMouseListener(new MouseHandler());
    results.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    results.setCellRenderer(new ResultRenderer());
    add(BorderLayout.CENTER, new JScrollPane(results));
}