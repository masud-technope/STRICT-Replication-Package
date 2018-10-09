//}}}
//}}}
//{{{ User input
//{{{ userInput() method
/**
	 * Handles the insertion of the specified character. It performs the
	 * following operations above and beyond simply inserting the text:
	 * <ul>
	 * <li>Inserting a TAB with a selection will shift to the right
	 * <li>Inserting a BACK_SPACE or a DELETE will remove a character
	 * <li>Inserting an indent open/close bracket will re-indent the current
	 * line as necessary
	 * </ul>
	 *
	 * @param ch The character
	 * @see #setSelectedText(String)
	 * @see #isOverwriteEnabled()
	 * @since jEdit 4.3pre7
	 */
public void userInput(char ch) {
    if (!isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    getPainter().hideCursor();
    switch(ch) {
        case '\t':
            userInputTab();
            break;
        case '\b':
            backspace();
            break;
        case '':
            delete();
            break;
        default:
            String str = String.valueOf(ch);
            if (getSelectionCount() == 0) {
                if (!doWordWrap(ch == ' ')) {
                    boolean indent = buffer.isElectricKey(ch, caretLine) && "full".equals(buffer.getStringProperty("autoIndent")) && /* if the line is not manually indented */
                    (buffer.getCurrentIndentForLine(caretLine, null) == buffer.getIdealIndentForLine(caretLine));
                    insert(str, indent);
                }
            } else
                replaceSelection(str);
            break;
    }
}