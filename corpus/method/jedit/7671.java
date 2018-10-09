// }}}
// {{{ split()
/**
	 * @param orig the original string
	 * @param delim a delimiter to use for splitting
	 * @return a new StringList containing the split strings.
	 */
public static StringList split(String orig, Object delim) {
    if ((orig == null) || (orig.length() == 0))
        return new StringList();
    return new StringList(orig.split(delim.toString()));
}