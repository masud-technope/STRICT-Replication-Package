//}}}
//{{{ remove() method
public void remove(DockableWindowManagerImpl.Entry entry) {
    if (entry.factory.name.equals(mostRecent))
        mostRecent = null;
    if (entry.win != null) {
        dockablePanel.remove(entry.win);
        entry.win = null;
    }
    if (current == entry) {
        current = null;
        show(current);
    } else {
        wm.revalidate();
        dockablePanel.repaint();
    }
}