/**
	 * Creates a new dockable window update message.
	 * @param wm The dockable window manager
	 * @param what What happened
	 * @param dockable The dockable window in question
	 */
public  DockableWindowUpdate(DockableWindowManager wm, Object what, String dockable) {
    super(wm);
    if (what == null)
        throw new NullPointerException("What must be non-null");
    this.what = what;
    this.dockable = dockable;
}