/**
	 * Adds a tool bar to this view.
	 * @param group The tool bar group to add to
	 * @param layer The layer of the group to add to
	 * @param toolBar The tool bar
	 * @see org.gjt.sp.jedit.gui.ToolBarManager
	 * @since jEdit 4.0pre7
	 */
public void addToolBar(int group, int layer, Component toolBar) {
    toolBarManager.addToolBar(group, layer, toolBar);
    getRootPane().revalidate();
}