//{{{ createPopupMenu() method
private void createPopupMenu() {
    if (popup != null)
        return;
    popup = (JPopupMenu) createPluginsMenu(new JPopupMenu(), true);
//}}}
}