// }}}
// {{{ createDockable()
protected JComponent createDockable(String name) {
    DockableWindowFactory.Window wf = factory.getDockableWindowFactory(name);
    if (wf == null) {
        Log.log(Log.ERROR, this, "Unknown dockable window: " + name);
        return null;
    }
    String position = getDockablePosition(name);
    JComponent window = wf.createDockableWindow(view, position);
    if (window != null)
        windows.put(name, window);
    return window;
}