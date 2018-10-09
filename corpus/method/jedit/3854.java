//}}}
public void show(String name) {
    DockableWindowManagerImpl.Entry entry = null;
    if (name != null) {
        wm.showDockableWindow(name);
        wm.hideDockableWindow(name);
    }
    show(entry);
}