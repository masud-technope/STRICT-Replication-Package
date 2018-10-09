/**
	 * Creates a new regular expression string matcher.
	 * @see java.util.regex.Pattern
	 * @param re the compiled regex
	 * @param ignoreCase <code>true</code> if you want to ignore case
	 * @param wholeWord <code>true</code> to search for whole word only
	 * @since jEdit 4.5pre1
	 */
public  PatternSearchMatcher(Pattern re, boolean ignoreCase, boolean wholeWord) {
    this(re.pattern(), ignoreCase);
    this.re = re;
    this.wholeWord = wholeWord;
}