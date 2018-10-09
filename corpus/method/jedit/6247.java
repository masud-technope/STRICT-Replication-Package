/**
	 * Creates a new regular expression already compiled.
	 * @see java.util.regex.Pattern
	 * @param re the compiled regex
	 * @param ignoreCase <code>true</code> if you want to ignore case
	 * @since jEdit 4.3pre13
	 */
public  PatternSearchMatcher(Pattern re, boolean ignoreCase) {
    this(re, ignoreCase, false);
}