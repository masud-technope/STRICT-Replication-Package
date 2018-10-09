 Entry(String name) {
    this.name = name;
    title = jEdit.getProperty(name + ".title");
    if (title == null)
        title = name;
    dockPosition = jEdit.getProperty(name + ".dock-position");
    if (dockPosition == null)
        dockPosition = DockableWindowManager.FLOATING;
}