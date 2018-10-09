/**
	 * Create a completion popup.
	 * It is not shown until reset() method is called with valid
	 * candidates. All key events for the view are intercepted by
	 * this popup untill end of completion.
	 * @since jEdit 4.3pre13
	 */
public  CompletionPopup(View view) {
    super(view);
    this.view = view;
    this.keyHandler = new KeyHandler();
    this.candidates = null;
    this.list = new JList();
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    list.setCellRenderer(new CellRenderer());
    list.addKeyListener(keyHandler);
    list.addMouseListener(new MouseHandler());
    list.setFocusTraversalKeysEnabled(false);
    JPanel content = new JPanel(new BorderLayout());
    content.setFocusTraversalKeysEnabled(false);
    // stupid scrollbar policy is an attempt to work around
    // bugs people have been seeing with IBM's JDK -- 7 Sep 2000
    JScrollPane scroller = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    content.add(scroller, BorderLayout.CENTER);
    setContentPane(content);
    addWindowFocusListener(new WindowFocusHandler());
}