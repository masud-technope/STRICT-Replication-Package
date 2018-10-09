// }}}
// {{{ applyDockingLayout
public void applyDockingLayout(DockingLayout docking) {
    // By default, use the docking positions specified by the jEdit properties
    for (Entry<String, String> entry : positions.entrySet()) {
        String dockable = entry.getKey();
        String position = entry.getValue();
        if (!position.equals(FLOATING))
            showDockableWindow(dockable);
    }
}