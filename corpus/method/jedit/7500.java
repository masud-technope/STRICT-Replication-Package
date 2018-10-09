//}}}
//{{{ removeToolBar() method
/**
	 * Removes a tool bar from this view.
	 * @param toolBar The tool bar
	 */
public void removeToolBar(Component toolBar) {
    if (toolBarManager == null)
        return;
    if (toolBar == null)
        return;
    toolBarManager.removeToolBar(toolBar);
    getRootPane().revalidate();
}