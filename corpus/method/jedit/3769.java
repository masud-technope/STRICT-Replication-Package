//{{{ MarkerViewer constructor
public  MarkerViewer(View view) {
    super(new BorderLayout());
    this.view = view;
    Box toolBar = new Box(BoxLayout.X_AXIS);
    toolBar.add(new JLabel(GenericGUIUtilities.prettifyMenuLabel(jEdit.getProperty("markers.label"))));
    toolBar.add(Box.createGlue());
    RolloverButton addMarker = new RolloverButton(GUIUtilities.loadIcon("Plus.png"));
    addMarker.setToolTipText(GenericGUIUtilities.prettifyMenuLabel(jEdit.getProperty("add-marker.label")));
    addMarker.addActionListener(this);
    addMarker.setActionCommand("add-marker");
    toolBar.add(addMarker);
    previous = new RolloverButton(GUIUtilities.loadIcon("ArrowL.png"));
    previous.setToolTipText(GenericGUIUtilities.prettifyMenuLabel(jEdit.getProperty("prev-marker.label")));
    previous.addActionListener(this);
    previous.setActionCommand("prev-marker");
    toolBar.add(previous);
    next = new RolloverButton(GUIUtilities.loadIcon("ArrowR.png"));
    next.setToolTipText(GenericGUIUtilities.prettifyMenuLabel(jEdit.getProperty("next-marker.label")));
    next.addActionListener(this);
    next.setActionCommand("next-marker");
    toolBar.add(next);
    clear = new RolloverButton(GUIUtilities.loadIcon("Clear.png"));
    clear.setToolTipText(GenericGUIUtilities.prettifyMenuLabel(jEdit.getProperty("remove-all-markers.label")));
    clear.addActionListener(this);
    clear.setActionCommand("clear");
    toolBar.add(clear);
    add(BorderLayout.NORTH, toolBar);
    markerList = new JList<Marker>();
    markerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    markerList.setCellRenderer(new Renderer());
    markerList.addMouseListener(new MouseHandler());
    markerList.addKeyListener(new KeyHandler());
    markerListScroller = new JScrollPane(markerList);
    add(BorderLayout.CENTER, markerListScroller);
    refreshList();
}