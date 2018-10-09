//{{{ SelectLineRange constructor
public  SelectLineRange(View view) {
    super(view, jEdit.getProperty("selectlinerange.title"), true);
    this.view = view;
    JPanel content = new JPanel(new BorderLayout());
    content.setBorder(new EmptyBorder(12, 12, 11, 11));
    setContentPane(content);
    JLabel label = new JLabel(jEdit.getProperty("selectlinerange.caption"));
    label.setBorder(new EmptyBorder(0, 0, 6, 12));
    content.add(BorderLayout.NORTH, label);
    JPanel panel = createFieldPanel();
    content.add(BorderLayout.CENTER, panel);
    panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
    panel.setBorder(new EmptyBorder(17, 0, 0, 0));
    ok = new JButton(jEdit.getProperty("common.ok"));
    ok.addActionListener(this);
    getRootPane().setDefaultButton(ok);
    cancel = new JButton(jEdit.getProperty("common.cancel"));
    cancel.addActionListener(this);
    GenericGUIUtilities.makeSameSize(ok, cancel);
    panel.add(Box.createGlue());
    panel.add(ok);
    panel.add(Box.createHorizontalStrut(6));
    panel.add(cancel);
    content.add(panel, BorderLayout.SOUTH);
    GenericGUIUtilities.requestFocus(this, startField);
    pack();
    setLocationRelativeTo(view);
    setVisible(true);
}