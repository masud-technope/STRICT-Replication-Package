/**
	 * Creates a new string literal matcher.
	 * @param pattern the search pattern
	 * @param ignoreCase <code>true</code> if you want to ignore case
	 * @param wholeWord <code>true</code> to search for whole word only
	 * @since 4.5pre1
	 */
public  BoyerMooreSearchMatcher(String pattern, boolean ignoreCase, boolean wholeWord) {
    this.pattern = pattern.toCharArray();
    if (ignoreCase) {
        for (int i = 0; i < this.pattern.length; i++) {
            this.pattern[i] = Character.toUpperCase(this.pattern[i]);
        }
    }
    this.ignoreCase = ignoreCase;
    pattern_end = this.pattern.length - 1;
    this.wholeWord = wholeWord;
}