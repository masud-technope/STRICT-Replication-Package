//}}}
//{{{ setHyperSearch() method
public void setHyperSearch(boolean hyperSearch) {
    jEdit.setBooleanProperty("view.search.hypersearch.toggle", hyperSearch);
    this.hyperSearch.setSelected(hyperSearch);
}