//}}}
//{{{ actionBar() method
/**
	 * Shows the action bar if needed, and sends keyboard focus there.
	 * @since jEdit 4.2pre1
	 */
public void actionBar() {
    if (actionBar == null)
        actionBar = new ActionBar(this, true);
    if (actionBar.getParent() == null)
        addToolBar(BOTTOM_GROUP, ACTION_BAR_LAYER, actionBar);
    actionBar.goToActionBar();
}