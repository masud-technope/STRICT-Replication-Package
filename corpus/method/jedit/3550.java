//}}}
//{{{ register() method
public void register(DockableWindowManagerImpl.Entry entry) {
    this.entry = entry;
    dockableName = entry.factory.name;
    setTitle(entry.shortTitle());
    getContentPane().add(BorderLayout.CENTER, entry.win);
    pack();
    Container parent = dockableWindowManager.getView();
    GUIUtilities.loadGeometry(this, parent, dockableName);
    GUIUtilities.addSizeSaver(this, parent, dockableName);
    KeyListener listener = dockableWindowManager.closeListener(dockableName);
    addKeyListener(listener);
    getContentPane().addKeyListener(listener);
    menu.addKeyListener(listener);
    entry.win.addKeyListener(listener);
    setVisible(true);
    if (!entry.win.isVisible())
        entry.win.setVisible(true);
}