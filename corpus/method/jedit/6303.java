//}}}
//{{{ update() method
public void update() {
    ignoreCase.setSelected(SearchAndReplace.getIgnoreCase());
    regexp.setSelected(SearchAndReplace.getRegexp());
    wholeWord.setSelected(SearchAndReplace.getWholeWord());
    hyperSearch.setSelected(jEdit.getBooleanProperty("view.search.hypersearch.toggle"));
}