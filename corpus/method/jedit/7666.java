/**
	 * Non-static version, that joins "this" StringList.
	 * @param delim the delimiter
	 * @return a joined string with delim inbetween each element
	 */
public String join(String delim) {
    int s = size();
    if (s < 1)
        return "";
    if (s == 1)
        return get(0);
    else {
        StringBuilder retval = new StringBuilder();
        retval.append(get(0));
        for (int i = 1; i < s; ++i) retval.append(delim + get(i));
        return retval.toString();
    }
}