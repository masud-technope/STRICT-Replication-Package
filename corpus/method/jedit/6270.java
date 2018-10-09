//}}}
//{{{ getSearchMatcher() method
/**
	 * Returns the current search string matcher.
	 * @return a SearchMatcher or null if there is no search or if the matcher can match empty String
	 *
	 * @exception IllegalArgumentException if regular expression search
	 * is enabled, the search string or replacement string is invalid
	 * @since jEdit 4.1pre7
	 */
public static SearchMatcher getSearchMatcher() throws Exception {
    if (matcher != null)
        return matcher;
    if (search == null || "".equals(search))
        return null;
    if (regexp) {
        Pattern re = Pattern.compile(search, PatternSearchMatcher.getFlag(ignoreCase));
        matcher = new PatternSearchMatcher(re, ignoreCase, wholeWord);
    } else
        matcher = new BoyerMooreSearchMatcher(search, ignoreCase, wholeWord);
    return matcher;
}