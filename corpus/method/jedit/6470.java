/**
	 * Creates a new <code>KeywordMap</code>.
	 * @param ignoreCase True if keys are case insensitive
	 */
public  KeywordMap(boolean ignoreCase) {
    this(ignoreCase, 52);
    this.ignoreCase = ignoreCase;
    noWordSep = new StringBuilder();
}