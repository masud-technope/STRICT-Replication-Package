//{{{ actionPerformed() method
@Override
public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == find)
        find(false);
    else if (source == hyperSearch) {
        jEdit.setBooleanProperty("view.search.hypersearch.toggle", hyperSearch.isSelected());
        update();
    } else if (source == ignoreCase) {
        SearchAndReplace.setIgnoreCase(ignoreCase.isSelected());
    } else if (source == regexp) {
        SearchAndReplace.setRegexp(regexp.isSelected());
    } else if (source == wholeWord) {
        SearchAndReplace.setWholeWord(wholeWord.isSelected());
    } else if (source == close) {
        view.removeToolBar(SearchBar.this);
        view.getEditPane().focusOnTextArea();
    }
//}}}
}