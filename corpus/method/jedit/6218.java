//}}}
//{{{ trimSearchString() method
private static String trimSearchString() {
    String s = SearchAndReplace.getSearchString();
    int length = jEdit.getIntegerProperty("hypersearch.displayQueryLength", 100);
    if (s.length() > length) {
        return s.substring(0, length) + "...";
    }
    return s;
}