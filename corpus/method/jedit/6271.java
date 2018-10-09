//}}}
//{{{ setSearchMatcher() method
/**
	 * Sets a custom search string matcher. Note that calling
	 * {@link #setSearchString(String)}, {@link #setWholeWord(boolean)},
	 * {@link #setIgnoreCase(boolean)}, or {@link #setRegexp(boolean)}
	 * will reset the matcher to the default.
	 */
public static void setSearchMatcher(SearchMatcher matcher) {
    SearchAndReplace.matcher = matcher;
    EditBus.send(new SearchSettingsChanged(null));
}