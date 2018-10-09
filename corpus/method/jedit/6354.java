/**
	 * Returns the offset of the first match of the specified text
	 * within this matcher.
	 * @param text The text to search in
	 * @param start True if the start of the text is the beginning of a line
	 * @param end True if the end of the text is the end of a line
	 * @param firstTime If false and the search string matched at the start
	 * offset with length zero, automatically find next match
	 * @param reverse If true, searching will be performed in a backward
	 * direction.
	 * @return A {@link Match} object.
	 * @since jEdit 4.3pre5
	 */
public abstract Match nextMatch(CharSequence text, boolean start, boolean end, boolean firstTime, boolean reverse) throws InterruptedException;