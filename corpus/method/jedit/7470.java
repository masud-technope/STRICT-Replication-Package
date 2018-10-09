//}}}
//{{{ quickHyperSearch() method
/**
	 * Quick HyperSearch.
	 * @since jEdit 4.0pre3
	 */
public void quickHyperSearch(boolean word) {
    JEditTextArea textArea = getTextArea();
    if (word) {
        String text = textArea.getSelectedText();
        if (text == null) {
            textArea.selectWord();
            text = textArea.getSelectedText();
        }
        if (text != null && text.indexOf('\n') == -1) {
            if (SearchAndReplace.getRegexp()) {
                text = SearchAndReplace.escapeRegexp(text, false);
            }
            HistoryModel.getModel("find").addItem(text);
            SearchAndReplace.setSearchString(text);
            SearchAndReplace.setSearchFileSet(new CurrentBufferSet());
            SearchAndReplace.hyperSearch(this);
            return;
        }
    }
    if (searchBar == null)
        searchBar = new SearchBar(this, true);
    if (searchBar.getParent() == null)
        addToolBar(TOP_GROUP, SEARCH_BAR_LAYER, searchBar);
    searchBar.setHyperSearch(true);
    searchBar.getField().setText(null);
    searchBar.getField().requestFocus();
    searchBar.getField().selectAll();
}