//}}}
//{{{ setReverseSearch() method
/**
	 * Determines whether a reverse search will conducted from the current
	 * position to the beginning of a buffer. Note that reverse search and
	 * regular expression search is mutually exclusive; enabling one will
	 * disable the other.
	 * @param reverse True if searches should go backwards,
	 * false otherwise
	 */
public static void setReverseSearch(boolean reverse) {
    if (reverse == SearchAndReplace.reverse)
        return;
    SearchAndReplace.reverse = reverse;
    EditBus.send(new SearchSettingsChanged(null));
}