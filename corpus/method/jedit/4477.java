/**
	 * Apply the indent rule to this line, and return an indent action.
	 *
	 * @param buffer the buffer
	 * @param thisLineIndex the line index
	 * @param prevLineIndex the prior non empty line index
	 * (or -1 if there is no prior non empty line)
	 * @param prevPrevLineIndex the prior non empty line index before the prevLineIndex
	 * (or -1 if there is no prior non empty line)
	 * @param indentActions the indent actions list. The rule can add an action in it if
	 * it is necessary
	 */
void apply(JEditBuffer buffer, int thisLineIndex, int prevLineIndex, int prevPrevLineIndex, List<IndentAction> indentActions);