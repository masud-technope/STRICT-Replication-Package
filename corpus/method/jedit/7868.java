// }}}
// {{{ setupTabs()
void setupTabs() {
    panes = new LinkedList<OptionPane>();
    shownPanes = new HashSet<OptionPane>();
    tabs = new JTabbedPane();
    JPanel content = new JPanel(new BorderLayout());
    content.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
    content.add(tabs, BorderLayout.CENTER);
    Box buttons = new Box(BoxLayout.X_AXIS);
    buttons.setBorder(BorderFactory.createEmptyBorder(12, 0, 0, 0));
    buttons.add(Box.createGlue());
    ok = new JButton(jEdit.getProperty("common.ok"));
    ok.addActionListener(this);
    getRootPane().setDefaultButton(ok);
    cancel = new JButton(jEdit.getProperty("common.cancel"));
    cancel.addActionListener(this);
    apply = new JButton(jEdit.getProperty("common.apply"));
    apply.addActionListener(this);
    int width = Math.max(Math.max(ok.getPreferredSize().width, cancel.getPreferredSize().width), apply.getPreferredSize().width);
    ok.setPreferredSize(new Dimension(width, ok.getPreferredSize().height));
    cancel.setPreferredSize(new Dimension(width, cancel.getPreferredSize().height));
    apply.setPreferredSize(new Dimension(width, apply.getPreferredSize().height));
    buttons.add(ok);
    buttons.add(Box.createHorizontalStrut(6));
    buttons.add(cancel);
    buttons.add(Box.createHorizontalStrut(6));
    buttons.add(apply);
    content.add(buttons, BorderLayout.SOUTH);
    setContentPane(content);
    GUIUtilities.loadGeometry(this, getName());
    tabs.addChangeListener(this);
}