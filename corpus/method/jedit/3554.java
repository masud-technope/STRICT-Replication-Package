//}}}
//{{{ unregister() method
public void unregister(DockableWindowManagerImpl.Entry entry) {
    this.entry = null;
    entry.btn = null;
    entry.container = null;
    // Note: entry.win must not be reset, to enable the dockable
    // instance to be moved instead of recreated if it uses the
    // MOVABLE attribute.
    super.dispose();
}