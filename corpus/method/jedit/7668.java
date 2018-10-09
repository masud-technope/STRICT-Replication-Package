// }}}
// {{{ join() methods
/**
	 * The reverse of split - given a collection, takes each element
	 * and places it in a string, joined by a delimiter.
	 */
public static String join(Collection<String> c, String delim) {
    StringList sl = new StringList();
    for (String s : c) sl.add(s);
    return sl.join(delim);
}