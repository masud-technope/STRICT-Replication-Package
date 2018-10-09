//}}}
//{{{ getKeywords() method
/**
	 * Returns an array containing all keywords in this keyword map.
	 * @since jEdit 4.0pre3
	 */
public String[] getKeywords() {
    List<String> vector = new ArrayList<String>(100);
    for (Keyword kw : map) {
        Keyword keyword = kw;
        while (keyword != null) {
            vector.add(new String(keyword.keyword));
            keyword = keyword.next;
        }
    }
    String[] retVal = new String[vector.size()];
    vector.toArray(retVal);
    return retVal;
}