//}}}
//{{{ quickIncrementalSearch() method
/**
	 * Quick search.
	 * @since jEdit 4.0pre3
	 */
public void quickIncrementalSearch(boolean word) {
    if (searchBar == null)
        searchBar = new SearchBar(this, true);
    if (searchBar.getParent() == null)
        addToolBar(TOP_GROUP, SEARCH_BAR_LAYER, searchBar);
    searchBar.setHyperSearch(false);
    JEditTextArea textArea = getTextArea();
    if (word) {
        String text = textArea.getSelectedText();
        if (text == null) {
            textArea.selectWord();
            text = textArea.getSelectedText();
        } else if (text.indexOf('\n') != -1)
            text = null;
        if (text != null && SearchAndReplace.getRegexp())
            text = SearchAndReplace.escapeRegexp(text, false);
        searchBar.getField().setText(text);
    }
    searchBar.getField().requestFocus();
    searchBar.getField().selectAll();
}