public  AddAbbrevDialog(View view, String abbrev) {
    super(view, jEdit.getProperty("add-abbrev.title"), false);
    this.view = view;
    JPanel content = new JPanel(new BorderLayout());
    content.setBorder(new EmptyBorder(12, 12, 12, 12));
    setContentPane(content);
    editor = new AbbrevEditor();
    editor.setAbbrev(abbrev);
    editor.setBorder(new EmptyBorder(6, 0, 12, 0));
    content.add(BorderLayout.CENTER, editor);
    Box box = new Box(BoxLayout.X_AXIS);
    box.add(Box.createGlue());
    global = new JButton(jEdit.getProperty("add-abbrev.global"));
    global.addActionListener(new ActionHandler());
    box.add(global);
    box.add(Box.createHorizontalStrut(6));
    modeSpecific = new JButton(jEdit.getProperty("add-abbrev.mode"));
    modeSpecific.addActionListener(new ActionHandler());
    box.add(modeSpecific);
    box.add(Box.createHorizontalStrut(6));
    cancel = new JButton(jEdit.getProperty("common.cancel"));
    cancel.addActionListener(new ActionHandler());
    box.add(cancel);
    box.add(Box.createGlue());
    content.add(BorderLayout.SOUTH, box);
    KeyListener listener = new KeyHandler();
    addKeyListener(listener);
    editor.getBeforeCaretTextArea().addKeyListener(listener);
    editor.getAfterCaretTextArea().addKeyListener(listener);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    if (abbrev == null)
        GenericGUIUtilities.requestFocus(this, editor.getAbbrevField());
    else
        GenericGUIUtilities.requestFocus(this, editor.getBeforeCaretTextArea());
    pack();
    setLocationRelativeTo(view);
    setVisible(true);
}