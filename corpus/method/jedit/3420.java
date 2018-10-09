//{{{ init() method
private void init(String abbrev, String expansion, Map abbrevs) {
    this.abbrevs = abbrevs;
    this.originalAbbrev = abbrev;
    JPanel content = new JPanel(new BorderLayout());
    content.setBorder(new EmptyBorder(12, 12, 11, 11));
    setContentPane(content);
    editor = new AbbrevEditor();
    editor.setAbbrev(abbrev);
    editor.setExpansion(expansion);
    editor.setBorder(new EmptyBorder(0, 0, 17, 0));
    content.add(BorderLayout.CENTER, editor);
    Box box = new Box(BoxLayout.X_AXIS);
    ok = new JButton(jEdit.getProperty("common.ok"));
    ok.addActionListener(new ActionHandler());
    getRootPane().setDefaultButton(ok);
    cancel = new JButton(jEdit.getProperty("common.cancel"));
    cancel.addActionListener(new ActionHandler());
    GenericGUIUtilities.makeSameSize(ok, cancel);
    box.add(Box.createGlue());
    box.add(ok);
    box.add(Box.createHorizontalStrut(6));
    box.add(cancel);
    content.add(BorderLayout.SOUTH, box);
    KeyListener listener = new KeyHandler();
    addKeyListener(listener);
    editor.getBeforeCaretTextArea().addKeyListener(listener);
    editor.getAfterCaretTextArea().addKeyListener(listener);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    pack();
    setLocationRelativeTo(getParent());
    setVisible(true);
}