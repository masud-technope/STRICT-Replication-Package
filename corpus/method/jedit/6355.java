/**
	 * Check if the result is a whole word
	 * @param text the full text search
	 * @param start the start match
	 * @param end the end match
	 * @return true if the word is a whole word
	 */
protected boolean isWholeWord(CharSequence text, int start, int end) {
    if (start != 0) {
        char firstChar = text.charAt(start);
        char prevChar = text.charAt(start - 1);
        if (!isEndWord(firstChar, prevChar)) {
            return false;
        }
    }
    if (end < text.length()) {
        char lastChar = text.charAt(end - 1);
        char nextChar = text.charAt(end);
        if (!isEndWord(lastChar, nextChar)) {
            return false;
        }
    }
    return true;
}