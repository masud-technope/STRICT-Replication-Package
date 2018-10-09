//}}}
//{{{ unregister() method
public void unregister(DockableWindowManagerImpl.Entry entry) {
    if (entry.factory.name.equals(mostRecent))
        mostRecent = null;
    if (entry.btn != null) {
        buttonPanel.remove(entry.btn);
        buttons.remove(entry.btn);
        entry.btn = null;
    }
    dockables.remove(entry);
    if (entry.win != null)
        dockablePanel.remove(entry.win);
    if (current == entry) {
        current = null;
        show(current);
    } else {
        wm.revalidate();
        dockablePanel.repaint();
        buttonPanel.repaint();
    }
}