/**
	 * Creates a new string literal matcher.
	 * @param pattern the search pattern
	 * @param ignoreCase <code>true</code> if you want to ignore case
	 */
public  BoyerMooreSearchMatcher(String pattern, boolean ignoreCase) {
    this(pattern, ignoreCase, false);
}