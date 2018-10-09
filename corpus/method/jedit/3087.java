public  AddModeDialog(View view) {
    super(view, jEdit.getProperty("options.editing.addMode.dialog.title"), true);
    JPanel content = new JPanel(new BorderLayout());
    content.setBorder(BorderFactory.createEmptyBorder(12, 12, 11, 11));
    setContentPane(content);
    // main content
    AbstractOptionPane mainContent = new AbstractOptionPane("addmode");
    mainContent.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    modeName = new JTextField(16);
    mainContent.addComponent(jEdit.getProperty("options.editing.addMode.dialog.modeName"), modeName);
    modeFile = new JTextField();
    browse = new JButton("...");
    browse.addActionListener(new ActionHandler());
    JPanel browsePanel = new JPanel(new BorderLayout());
    browsePanel.add(modeFile, BorderLayout.CENTER);
    browsePanel.add(browse, BorderLayout.EAST);
    mainContent.addComponent(jEdit.getProperty("options.editing.addMode.dialog.modeFile"), browsePanel);
    filenameGlob = new JTextField(16);
    mainContent.addComponent(jEdit.getProperty("options.editing.addMode.dialog.filenameGlob"), filenameGlob);
    firstLineGlob = new JTextField();
    mainContent.addComponent(jEdit.getProperty("options.editing.addMode.dialog.firstLineGlob"), firstLineGlob);
    content.add(mainContent);
    // buttons
    JPanel buttons = new JPanel();
    buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
    buttons.setBorder(BorderFactory.createEmptyBorder(17, 0, 0, 6));
    ok = new JButton(jEdit.getProperty("common.ok"));
    ok.addActionListener(new ActionHandler());
    getRootPane().setDefaultButton(ok);
    cancel = new JButton(jEdit.getProperty("common.cancel"));
    cancel.addActionListener(new ActionHandler());
    GenericGUIUtilities.makeSameSize(ok, cancel);
    buttons.add(Box.createGlue());
    buttons.add(ok);
    buttons.add(Box.createHorizontalStrut(6));
    buttons.add(cancel);
    content.add(BorderLayout.SOUTH, buttons);
    pack();
    setLocationRelativeTo(view);
    setVisible(true);
}