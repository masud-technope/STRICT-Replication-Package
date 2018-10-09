//{{{ FloatingWindowContainer constructor
public  FloatingWindowContainer(DockableWindowManagerImpl dockableWindowManager, boolean clone) {
    this.dockableWindowManager = dockableWindowManager;
    dockableWindowManager.addPropertyChangeListener(this);
    this.clone = clone;
    setIconImage(GUIUtilities.getPluginIcon());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    Box caption = new Box(BoxLayout.X_AXIS);
    caption.add(menu = new RolloverButton(GUIUtilities.loadIcon(jEdit.getProperty("dropdown-arrow.icon"))));
    menu.addMouseListener(new MouseHandler());
    menu.setToolTipText(jEdit.getProperty("docking.menu.label"));
    Box separatorBox = new Box(BoxLayout.Y_AXIS);
    separatorBox.add(Box.createVerticalStrut(3));
    separatorBox.add(new JSeparator(JSeparator.HORIZONTAL));
    separatorBox.add(Box.createVerticalStrut(3));
    caption.add(separatorBox);
    getContentPane().add(BorderLayout.NORTH, caption);
}