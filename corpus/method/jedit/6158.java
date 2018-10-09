//{{{ HyperSearchOperationNode constructor
public  HyperSearchOperationNode(String searchString, SearchMatcher searchMatcher) {
    this.searchString = searchString;
    this.searchMatcher = searchMatcher;
    noWordSep = searchMatcher.getNoWordSep();
}