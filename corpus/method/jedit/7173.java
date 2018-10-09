//}}}
//{{{ home() method
/**
	 * A "dumb home" action which only has 2 states:
	 *     start of the whitespace or start of line
	 *     @param select true if we also want to select from the cursor
	 * @since jedit 4.3pre18
	 */
public void home(boolean select) {
    switch(getInputHandler().getLastActionCount() % 2) {
        case 1:
            goToStartOfWhiteSpace(select);
            break;
        default:
            goToStartOfLine(select);
            break;
    }
}