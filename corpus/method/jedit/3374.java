//}}}
//}}}
//{{{ propertiesChanged() method
protected void propertiesChanged() {
    if (view.isPlainView())
        return;
    ((DockableLayout) getLayout()).setAlternateLayout(jEdit.getBooleanProperty("view.docking.alternateLayout"));
    String[] windowList = factory.getRegisteredDockableWindows();
    for (String dockable : windowList) {
        Entry entry = windows.get(dockable);
        if (entry == null) {
            // is not yet created if the plugin has some jars.
            continue;
        }
        String newPosition = jEdit.getProperty(dockable + ".dock-position", FLOATING);
        if (newPosition.equals(entry.position))
            continue;
        entry.position = newPosition;
        if (entry.container != null) {
            entry.container.unregister(entry);
            entry.container = null;
            if (entry.factory.movable && (!newPosition.equals(FLOATING))) {
                if (entry.win instanceof DockableWindow)
                    ((DockableWindow) entry.win).move(newPosition);
            } else
                entry.win = null;
        }
        if (newPosition.equals(FLOATING)) {
        } else {
            if (newPosition.equals(TOP))
                entry.container = top;
            else if (newPosition.equals(LEFT))
                entry.container = left;
            else if (newPosition.equals(BOTTOM))
                entry.container = bottom;
            else if (newPosition.equals(RIGHT))
                entry.container = right;
            else {
                Log.log(Log.WARNING, this, "Unknown position: " + newPosition);
                continue;
            }
            entry.container.register(entry);
        }
    }
    top.sortDockables();
    left.sortDockables();
    bottom.sortDockables();
    right.sortDockables();
    continuousLayout = UIManager.getBoolean("SplitPane.continuousLayout");
    revalidate();
    repaint();
}