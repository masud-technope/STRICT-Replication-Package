//}}}
//{{{ smartEnd() method
/**
	 * Has 4 states based on # of invocations:
	 *   1. last character of code (before inline comment)
	 *   2. last non whitespace character of the line
	 *   3. end of line
	 *   4. end of last visible line
	 * @param select true if you want to extend selection
	 * @since jEdit 4.3pre18
	 */
public void smartEnd(boolean select) {
    switch(getInputHandler().getLastActionCount()) {
        case 1:
            int pos = getCaretPosition();
            goToEndOfCode(select);
            int npos = getCaretPosition();
            if (npos == pos)
                goToEndOfWhiteSpace(select);
            break;
        case 2:
            goToEndOfWhiteSpace(select);
            break;
        case 3:
            goToEndOfLine(select);
            break;
        default:
            //case 4:
            goToLastVisibleLine(select);
            break;
    }
}