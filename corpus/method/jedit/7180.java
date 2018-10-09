//}}}
//{{{ smartHome() method
/**
	 * On subsequent invocations, first moves the caret to the first
	 * non-whitespace character of the line, then the beginning of the
	 * line, then to the first visible line.
	 * @param select true if you want to extend selection
	 * @since jEdit 4.3pre7
	 */
public void smartHome(boolean select) {
    switch(getInputHandler().getLastActionCount()) {
        case 1:
            goToStartOfWhiteSpace(select);
            break;
        case 2:
            goToStartOfLine(select);
            break;
        default:
            //case 3:
            goToFirstVisibleLine(select);
            break;
    }
}