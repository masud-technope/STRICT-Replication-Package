//{{{ createMenuItem() methods
private JMenuItem createMenuItem(String name, String iconName) {
    JMenuItem jMenuItem = GUIUtilities.loadMenuItem(VFSBrowser.getActionContext(), "vfs.browser." + name, false);
    jMenuItem.setIcon(GUIUtilities.loadIcon(iconName));
    return jMenuItem;
}