public  BufferOptions(View view, Buffer buffer) {
    super(view, jEdit.getProperty("buffer-options.title"), true);
    JPanel content = new JPanel(new BorderLayout());
    content.setBorder(new EmptyBorder(12, 12, 12, 12));
    setContentPane(content);
    ActionHandler actionListener = new ActionHandler();
    panel = new BufferOptionPane();
    content.add(BorderLayout.NORTH, panel);
    //{{{ Buttons
    JPanel buttons = new JPanel();
    buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
    buttons.setBorder(new EmptyBorder(12, 0, 0, 0));
    buttons.add(Box.createGlue());
    ok = new JButton(jEdit.getProperty("common.ok"));
    ok.addActionListener(actionListener);
    getRootPane().setDefaultButton(ok);
    cancel = new JButton(jEdit.getProperty("common.cancel"));
    cancel.addActionListener(actionListener);
    ok.setPreferredSize(cancel.getPreferredSize());
    buttons.add(ok);
    buttons.add(Box.createHorizontalStrut(6));
    buttons.add(cancel);
    //buttons.add(Box.createGlue());
    content.add(BorderLayout.SOUTH, buttons);
    //}}}
    pack();
    setLocationRelativeTo(view);
    setVisible(true);
}