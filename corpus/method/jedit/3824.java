//{{{ PanelWindowContainer constructor
public  PanelWindowContainer(DockableWindowManagerImpl wm, String position, int dimension) {
    this.wm = wm;
    this.position = position;
    //{{{ Button box setup
    buttonPanel = new JPanel(new ButtonLayout());
    buttonPanel.setBorder(new EmptyBorder(1, 1, 1, 1));
    closeBox = new JButton(GUIUtilities.loadIcon("closebox.gif"));
    closeBox.setRequestFocusEnabled(false);
    closeBox.setToolTipText(jEdit.getProperty("view.docking.close-tooltip"));
    if (OperatingSystem.isMacOSLF())
        closeBox.putClientProperty("JButton.buttonType", "toolbar");
    closeBox.setMargin(new Insets(0, 0, 0, 0));
    GenericGUIUtilities.setButtonContentMargin(closeBox, closeBox.getMargin());
    closeBox.addActionListener(new ActionHandler());
    menuBtn = new JButton(GUIUtilities.loadIcon(jEdit.getProperty("dropdown-arrow.icon")));
    menuBtn.setRequestFocusEnabled(false);
    menuBtn.setToolTipText(jEdit.getProperty("view.docking.menu-tooltip"));
    if (OperatingSystem.isMacOSLF())
        menuBtn.putClientProperty("JButton.buttonType", "toolbar");
    menuBtn.setMargin(new Insets(0, 0, 0, 0));
    GenericGUIUtilities.setButtonContentMargin(menuBtn, menuBtn.getMargin());
    menuBtn.addMouseListener(new MenuMouseHandler());
    buttonGroup = new ButtonGroup();
    // JDK 1.4 workaround
    buttonGroup.add(nullButton = new JToggleButton());
    //}}}
    dockables = new ArrayList<DockableWindowManagerImpl.Entry>();
    buttons = new ArrayList<AbstractButton>();
    dockablePanel = new DockablePanel(this);
    this.dimension = dimension;
}