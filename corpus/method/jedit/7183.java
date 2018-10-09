//}}}
//{{{ end() method
/**
	 * a dumb end action which only has 2 states:
	 * 	end of whitespace or end of line
	 * @param select true if we also want to select from the cursor
	 * @since jedit 4.3pre18
	 */
public void end(boolean select) {
    switch(getInputHandler().getLastActionCount() % 2) {
        case 1:
            goToEndOfWhiteSpace(select);
            break;
        default:
            goToEndOfLine(select);
            break;
    }
}