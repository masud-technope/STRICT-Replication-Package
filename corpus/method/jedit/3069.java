//{{{ CompletionPopup constructor
 CompletionPopup(String[] actions) {
    super(view);
    setContentPane(new JPanel(new BorderLayout()) {

        /**
				 * Makes the tab key work in Java 1.4.
				 */
        @Override
        public boolean getFocusTraversalKeysEnabled() {
            return false;
        }
    });
    list = new CompletionList<String>(actions);
    list.setVisibleRowCount(8);
    list.addMouseListener(new MouseHandler());
    list.setSelectedIndex(0);
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    // stupid scrollbar policy is an attempt to work around
    // bugs people have been seeing with IBM's JDK -- 7 Sep 2000
    JScrollPane scroller = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    getContentPane().add(scroller, BorderLayout.CENTER);
    GenericGUIUtilities.requestFocus(this, list);
    pack();
    Point p = new Point(0, -getHeight());
    SwingUtilities.convertPointToScreen(p, action);
    setLocation(p);
    setVisible(true);
    KeyHandler keyHandler = new KeyHandler();
    addKeyListener(keyHandler);
    list.addKeyListener(keyHandler);
//}}}
}