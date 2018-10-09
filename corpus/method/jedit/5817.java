//}}}
//{{{ init() method
private void init() {
    EditBus.addToBus(this);
    /* Setup panes */
    JPanel content = new JPanel(new BorderLayout(12, 12));
    content.setBorder(new EmptyBorder(12, 12, 12, 12));
    setContentPane(content);
    tabPane = new JTabbedPane();
    tabPane.addTab(jEdit.getProperty("manage-plugins.title"), manager = new ManagePanel(this));
    tabPane.addTab(jEdit.getProperty("update-plugins.title"), updater = new InstallPanel(this, true));
    tabPane.addTab(jEdit.getProperty("install-plugins.title"), installer = new InstallPanel(this, false));
    EditBus.addToBus(installer);
    content.add(BorderLayout.CENTER, tabPane);
    tabPane.addChangeListener(new ListUpdater());
    /* Create the buttons */
    Box buttons = new Box(BoxLayout.X_AXIS);
    ActionListener al = new ActionHandler();
    mgrOptions = new JButton(jEdit.getProperty("plugin-manager.mgr-options"));
    mgrOptions.addActionListener(al);
    pluginOptions = new JButton(jEdit.getProperty("plugin-manager.plugin-options"));
    pluginOptions.addActionListener(al);
    done = new JButton(jEdit.getProperty("plugin-manager.done"));
    done.addActionListener(al);
    buttons.add(Box.createGlue());
    buttons.add(mgrOptions);
    buttons.add(Box.createHorizontalStrut(6));
    buttons.add(pluginOptions);
    buttons.add(Box.createHorizontalStrut(6));
    buttons.add(done);
    getRootPane().setDefaultButton(done);
    content.add(BorderLayout.SOUTH, buttons);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setIconImage(GUIUtilities.getPluginIcon());
    pack();
    GUIUtilities.loadGeometry(this, parent, "plugin-manager");
    GUIUtilities.addSizeSaver(this, parent, "plugin-manager");
    setVisible(true);
}