@Override
public void run() {
    DockableWindowManager wm = view.getDockableWindowManager();
    wm.setDockingLayout(config.docking);
    startupDone.set(startupDoneIndex, true);
}