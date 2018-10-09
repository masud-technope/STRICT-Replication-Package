//{{{ Getters and setters
//{{{ setSearchString() method
/**
	 * Sets the current search string.
	 * @param search The new search string
	 */
public static void setSearchString(String search) {
    if (search.equals(SearchAndReplace.search))
        return;
    SearchAndReplace.search = search;
    matcher = null;
    EditBus.send(new SearchSettingsChanged(null));
}