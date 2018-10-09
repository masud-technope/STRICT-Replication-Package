//{{{ PluginManagerProgress constructor
 PluginManagerProgress(PluginManager dialog, Roster roster) {
    super(dialog, jEdit.getProperty("plugin-manager.progress.title"), true);
    this.roster = roster;
    JPanel content = new JPanel(new BorderLayout(12, 12));
    content.setBorder(new EmptyBorder(12, 12, 12, 12));
    setContentPane(content);
    progress = new JProgressBar();
    progress.setStringPainted(true);
    count = roster.getOperationCount();
    int maximum = 0;
    for (int i = 0; i < count; i++) {
        maximum += roster.getOperation(i).getMaximum();
    }
    progress.setMaximum(maximum);
    content.add(BorderLayout.NORTH, progress);
    stop = new JButton(jEdit.getProperty("plugin-manager.progress.stop"));
    stop.addActionListener(new ActionHandler());
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    panel.add(stop);
    content.add(BorderLayout.CENTER, panel);
    addWindowListener(new WindowHandler());
    pack();
    setLocationRelativeTo(dialog);
    setVisible(true);
}