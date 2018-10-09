/**
	 * Returns a replaced string for a Matcher which has been matched
	 * by find() method.
	 */
private static String extractReplacement(Matcher found, int appendPosition, String replacement) {
    /*
		 * It doesn't make sense to read before start, but
		 * appendReplacement() requires to to it.
		 */
    int found_start = found.start();
    int found_end = found.end();
    int source_length = found_end - found_start;
    int length_before_match = found_start - appendPosition;
    StringBuffer replaced = new StringBuffer(length_before_match + (source_length * 2));
    found.appendReplacement(replaced, replacement);
    return replaced.substring(length_before_match);
}