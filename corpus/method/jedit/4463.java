/**
	 * @param buffer The buffer
	 * @param line The line number that matched the rule; not necessarily
	 * the line being indented.
	 * @param oldIndent Original indent.
	 * @param newIndent The new indent -- ie, indent returned by previous
	 * indent action.
	 */
int calculateIndent(JEditBuffer buffer, int line, int oldIndent, int newIndent);