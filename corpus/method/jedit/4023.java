//{{{ ErrorDialog constructor
private  ErrorDialog(Frame view) {
    super(view, "Errors", false);
    byteArrayOutputStream = new ByteArrayOutputStream();
    printStream = new PrintStream(byteArrayOutputStream);
    throwables = Log.throwables.toArray(new Throwable[0]);
    textArea = new JEditEmbeddedTextArea();
    JEditActionSet<JEditBeanShellAction> actionSet = new StandaloneTextArea.StandaloneActionSet(jEdit.getPropertyManager(), textArea, TextArea.class.getResource("textarea.actions.xml"));
    textArea.addActionSet(actionSet);
    actionSet.load();
    actionSet.initKeyBindings();
    Keymap keymap = jEdit.getKeymapManager().getKeymap();
    String shortcut = keymap.getShortcut("copy.shortcut");
    if (shortcut != null)
        textArea.getInputHandler().addKeyBinding(shortcut, "copy");
    String shortcut2 = keymap.getShortcut("copy.shortcut2");
    if (shortcut2 != null)
        textArea.getInputHandler().addKeyBinding(shortcut2, "copy");
    JPopupMenu menu = new JPopupMenu();
    JMenuItem copy = new JMenuItem(jEdit.getProperty("copy.label").replace("$", ""));
    copy.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            Registers.copy(textArea, '$');
        }
    });
    menu.add(copy);
    textArea.setRightClickPopup(menu);
    textArea.setRightClickPopupEnabled(true);
    textArea.getBuffer().setMode(jEdit.getMode("logs"));
    if (throwables.length != 0) {
        Throwable throwable = (Throwable) throwables[0];
        setThrowable(throwable);
    }
    combo = new JComboBox<Throwable>(throwables);
    combo.addItemListener(new ItemListener() {

        @Override
        public void itemStateChanged(ItemEvent e) {
            setThrowable((Throwable) combo.getSelectedItem());
        }
    });
    getContentPane().add(combo, BorderLayout.NORTH);
    getContentPane().add(new JScrollPane(textArea));
    Box buttons = new Box(BoxLayout.X_AXIS);
    buttons.add(Box.createGlue());
    buttons.add(removeThisError = new JButton(jEdit.getProperty("common.removeCurrent")));
    buttons.add(Box.createHorizontalStrut(6));
    buttons.add(removeAllErrors = new JButton(jEdit.getProperty("common.clearAll")));
    ActionListener actionListener = new MyActionListener();
    removeThisError.addActionListener(actionListener);
    removeAllErrors.addActionListener(actionListener);
    buttons.add(Box.createGlue());
    getContentPane().add(buttons, BorderLayout.SOUTH);
    pack();
    GUIUtilities.loadGeometry(this, "status.errorWidget");
    setVisible(true);
//}}}
}