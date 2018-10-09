//}}}
//{{{ handleSearchSettingsChanged() method
@EBHandler
public void handleSearchSettingsChanged(SearchSettingsChanged msg) {
    if (searchBar != null)
        searchBar.update();
}