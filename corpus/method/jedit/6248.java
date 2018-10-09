/**
	 * Creates a new regular expression string matcher.
	 * @see java.util.regex.Pattern
	 * @param search the search pattern
	 * @param ignoreCase <code>true</code> if you want to ignore case
	 * @since jEdit 4.3pre5
	 */
public  PatternSearchMatcher(String search, boolean ignoreCase) {
    pattern = search;
    flags = getFlag(ignoreCase);
}