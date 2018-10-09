//}}}
//{{{ updateBufferSwitcherStates() method
/**
	 * Enables or Disables the "Focus Buffer Switcher" menu item in the View menu
	 * depending on the visible state of the buffer switcher.  The menu item
	 * is intended to have the same effect as clicking on the buffer switcher
	 * combo box, and it doesn't make sense to have this action available if
	 * the buffer switcher isn't visible.
	 * Also shows or hides the Buffer Switcher itself, since this can be invoked after
	 * the toggle buffer switcher action.
	 */
public void updateBufferSwitcherStates() {
    boolean show = jEdit.getBooleanProperty("view.showBufferSwitcher");
    JMenuBar menubar = getJMenuBar();
    if (menubar == null) {
        return;
    }
    String viewmenu_label = jEdit.getProperty("view.label");
    viewmenu_label = viewmenu_label.replace("$", "");
    String sbs_label = jEdit.getProperty("focus-buffer-switcher.label");
    sbs_label = sbs_label.replace("$", "");
    JMenu viewmenu = null;
    for (int i = 0; i < menubar.getMenuCount(); i++) {
        JMenu menu = menubar.getMenu(i);
        if (menu.getText().equals(viewmenu_label)) {
            viewmenu = menu;
            break;
        }
    }
    if (viewmenu != null) {
        for (int i = 0; i < viewmenu.getMenuComponentCount(); i++) {
            Component item = viewmenu.getMenuComponent(i);
            if (item instanceof JMenuItem && ((JMenuItem) item).getText().equals(sbs_label)) {
                item.setEnabled(show);
            // viewmenu.invalidate();
            }
        }
    }
    // Toggle the visibility of the BufferSwitcher itself
    for (View v : jEdit.getViews()) for (EditPane ep : v.getEditPanes()) ep.loadBufferSwitcher();
}