//}}}
//{{{ loadToolBars() method
private void loadToolBars() {
    if (!plainView && (fullScreenMode ? jEdit.getBooleanProperty("fullScreenIncludesToolbar") : jEdit.getBooleanProperty("view.showToolbar"))) {
        if (toolBar != null)
            toolBarManager.removeToolBar(toolBar);
        toolBar = GUIUtilities.loadToolBar("view.toolbar");
        addToolBar(TOP_GROUP, SYSTEM_BAR_LAYER, toolBar);
    } else if (toolBar != null) {
        removeToolBar(toolBar);
        toolBar = null;
    }
    if (searchBar != null) {
        searchBar.propertiesChanged();
        removeToolBar(searchBar);
    }
    if (jEdit.getBooleanProperty("view.showSearchbar") && !plainView) {
        if (searchBar == null)
            searchBar = new SearchBar(this, false);
        addToolBar(TOP_GROUP, SEARCH_BAR_LAYER, searchBar);
    }
}