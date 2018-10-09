//}}}
//{{{ goToEndOfCode() method
/**
	 * Moves the caret to the end of the code present on the current line, before the comments and whitespace.
	 * @param select true if you want to extend selection
	 * @since jEdit 4.3pre18
	 */
public void goToEndOfCode(boolean select) {
    int line = getCaretLine();
    DefaultTokenHandler tokenHandler = new DefaultTokenHandler();
    buffer.markTokens(line, tokenHandler);
    Token token = tokenHandler.getTokens();
    char[] txt = getLineText(line).toCharArray();
    // replace comments with whitespace to find endOfCode:
    while (true) {
        if (token.id == Token.COMMENT1 || token.id == Token.COMMENT2 || token.id == Token.COMMENT3 || token.id == Token.COMMENT4) {
            for (int i = token.offset; i < token.offset + token.length; i++) {
                txt[i] = ' ';
            }
        }
        if (token.next == null)
            break;
        token = token.next;
    }
    int newCaret = getLineLength(line) - StandardUtilities.getTrailingWhiteSpace(new String(txt));
    newCaret += getLineStartOffset(line);
    if (select)
        extendSelection(caret, newCaret);
    else if (!multi)
        selectNone();
    moveCaretPosition(newCaret);
}