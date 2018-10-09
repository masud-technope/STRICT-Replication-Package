/**
	 * Creates a new <code>KeywordMap</code>.
	 * @param ignoreCase True if the keys are case insensitive
	 * @param mapLength The number of `buckets' to create.
	 * A value of 52 will give good performance for most maps.
	 */
public  KeywordMap(boolean ignoreCase, int mapLength) {
    this.mapLength = mapLength;
    this.ignoreCase = ignoreCase;
    map = new Keyword[mapLength];
}