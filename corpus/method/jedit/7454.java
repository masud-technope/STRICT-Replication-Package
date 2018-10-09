//}}}
//{{{ updateFullScreenProps() method
public void updateFullScreenProps() {
    boolean alternateLayout = jEdit.getBooleanProperty("view.toolbar.alternateLayout");
    boolean showMenu = jEdit.getBooleanProperty("fullScreenIncludesMenu");
    boolean showToolbars = jEdit.getBooleanProperty("fullScreenIncludesToolbar");
    boolean showStatus = jEdit.getBooleanProperty("fullScreenIncludesStatus");
    if (!showMenu) {
        menuBar = getJMenuBar();
        setJMenuBar(null);
    } else if (menuBar != null)
        setJMenuBar(menuBar);
    // Note: Bottom toolbar is the action bar, which is always enabled
    loadToolBars();
    if (alternateLayout) {
        if (!showStatus)
            removeToolBar(status);
        else
            addToolBar(BOTTOM_GROUP, STATUS_BAR_LAYER, status);
    } else {
        if (!showStatus)
            getContentPane().remove(status);
        else
            getContentPane().add(BorderLayout.SOUTH, status);
    }
}