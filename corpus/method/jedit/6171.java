//{{{ HyperSearchRequest constructor
 HyperSearchRequest(View view, SearchMatcher matcher, HyperSearchResults results, Selection[] selection) {
    this.view = view;
    this.matcher = matcher;
    this.results = results;
    searchString = SearchAndReplace.getSearchString();
    rootSearchNode = new DefaultMutableTreeNode(new HyperSearchOperationNode(searchString, matcher));
    this.selection = selection;
}