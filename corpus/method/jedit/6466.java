//}}}
//{{{ add() method
/**
	 * Adds the content of another keyword map to this one.
	 * @since jEdit 4.2pre3
	 */
public void add(KeywordMap map) {
    for (int i = 0; i < map.map.length; i++) {
        Keyword k = map.map[i];
        while (k != null) {
            add(k.keyword, k.id);
            k = k.next;
        }
    }
}