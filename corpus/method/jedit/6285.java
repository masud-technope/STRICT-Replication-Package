//}}}
//{{{ _replace() method
/**
	 * Replaces all occurrences of the search string with the replacement
	 * string.
	 * @param view The view
	 * @param buffer The buffer
	 * @param start The start offset
	 * @param end The end offset
	 * @param matcher The search matcher to use
	 * @param smartCaseReplace See user's guide
	 * @return The number of occurrences replaced
	 */
private static int _replace(View view, JEditBuffer buffer, SearchMatcher matcher, int start, int end, boolean smartCaseReplace) throws Exception {
    if (matcher.wholeWord) {
        String noWordSep = buffer.getStringProperty("noWordSep");
        matcher.setNoWordSep(noWordSep);
    }
    int occurCount = 0;
    boolean endOfLine = (buffer.getLineEndOffset(buffer.getLineOfOffset(end)) - 1 == end);
    int offset = start;
    loop: for (int counter = 0; ; counter++) {
        boolean startOfLine = (buffer.getLineStartOffset(buffer.getLineOfOffset(offset)) == offset);
        CharSequence text = buffer.getSegment(offset, end - offset);
        SearchMatcher.Match occur = matcher.nextMatch(text, startOfLine, endOfLine, counter == 0, false);
        if (occur == null)
            break loop;
        CharSequence found = text.subSequence(occur.start, occur.end);
        int length = replaceOne(view, buffer, occur, offset, found, smartCaseReplace);
        if (length == -1)
            offset += occur.end;
        else {
            offset += occur.start + length;
            end += (length - found.length());
            occurCount++;
        }
    }
    return occurCount;
}