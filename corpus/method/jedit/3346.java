/**
	 * Creates a new dockable window manager.
	 * @param view The view
	 * @param factory A {@link DockableWindowFactory}, usually
	 * <code>DockableWindowFactory.getInstance()</code>.
	 * @param config A docking configuration
	 * @since jEdit 2.6pre3
	 */
public  DockableWindowManagerImpl(View view, DockableWindowFactory factory, View.ViewConfig config) {
    super(view, factory, config);
    setLayout(new DockableLayout());
    windows = new HashMap<String, Entry>();
    clones = new ArrayList<Entry>();
    DockableWindowConfig docking = (DockableWindowConfig) config.docking;
    if (docking == null)
        docking = new DockableWindowConfig();
    top = new PanelWindowContainer(this, TOP, docking.topPos);
    left = new PanelWindowContainer(this, LEFT, docking.leftPos);
    bottom = new PanelWindowContainer(this, BOTTOM, docking.bottomPos);
    right = new PanelWindowContainer(this, RIGHT, docking.rightPos);
    add(DockableLayout.TOP_BUTTONS, top.buttonPanel);
    add(DockableLayout.LEFT_BUTTONS, left.buttonPanel);
    add(DockableLayout.BOTTOM_BUTTONS, bottom.buttonPanel);
    add(DockableLayout.RIGHT_BUTTONS, right.buttonPanel);
    add(TOP, top.dockablePanel);
    add(LEFT, left.dockablePanel);
    add(BOTTOM, bottom.dockablePanel);
    add(RIGHT, right.dockablePanel);
}