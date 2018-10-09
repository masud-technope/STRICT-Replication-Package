//{{{ RegisterViewer constructor
public  RegisterViewer(View view, String position) {
    super(new BorderLayout());
    this.view = view;
    Box toolBar = new Box(BoxLayout.X_AXIS);
    JLabel label = new JLabel(jEdit.getProperty("view-registers.title"));
    label.setBorder(new EmptyBorder(0, 0, 3, 0));
    toolBar.add(label);
    toolBar.add(Box.createGlue());
    RolloverButton pasteRegister = new RolloverButton(GUIUtilities.loadIcon("Paste.png"));
    pasteRegister.setToolTipText(GenericGUIUtilities.prettifyMenuLabel(jEdit.getProperty("paste-string-register.label")));
    pasteRegister.addActionListener(new InsertHandler());
    pasteRegister.setActionCommand("paste-string-register");
    toolBar.add(pasteRegister);
    RolloverButton clearRegister = new RolloverButton(GUIUtilities.loadIcon("Clear.png"));
    clearRegister.setToolTipText(GenericGUIUtilities.prettifyMenuLabel(jEdit.getProperty("clear-string-register.label")));
    clearRegister.addActionListener(new ClearHandler());
    clearRegister.setActionCommand("clear-string-register");
    toolBar.add(clearRegister);
    add(BorderLayout.NORTH, toolBar);
    DefaultListModel<String> registerModel = new DefaultListModel<String>();
    registerList = new JList<String>(registerModel);
    registerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    registerList.setCellRenderer(new Renderer());
    registerList.addListSelectionListener(new ListHandler());
    registerList.addMouseListener(new MouseHandler());
    contentTextArea = new JTextArea(10, 20);
    contentTextArea.setEditable(true);
    documentHandler = new DocumentHandler();
    //contentTextArea.getDocument().addDocumentListener(documentHandler);
    contentTextArea.addFocusListener(new FocusHandler());
    //key bindings
    this.registerKeyboardAction(new EscapeHandler(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    registerList.registerKeyboardAction(new InsertHandler(), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), WHEN_FOCUSED);
    registerList.registerKeyboardAction(new InsertHandler(), KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0), WHEN_FOCUSED);
    registerList.registerKeyboardAction(new ClearHandler(), KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), WHEN_FOCUSED);
    contentTextArea.registerKeyboardAction(new TabHandler(), KeyStroke.getKeyStroke(KeyEvent.VK_TAB, InputEvent.SHIFT_DOWN_MASK), WHEN_FOCUSED);
    int orientation = JSplitPane.HORIZONTAL_SPLIT;
    if (position.equals(DockableWindowManager.LEFT) || position.equals(DockableWindowManager.RIGHT))
        orientation = JSplitPane.VERTICAL_SPLIT;
    add(BorderLayout.CENTER, splitPane = new JSplitPane(orientation, new JScrollPane(registerList), new JScrollPane(contentTextArea)));
    refreshList();
}