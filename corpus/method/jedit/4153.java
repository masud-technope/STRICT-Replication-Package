//{{{ invokeForCaret() method
/**
	 * Edit the syntax style of the token under the caret.
	 *
	 * @param textArea the textarea where your caret is
	 * @since jEdit 4.4pre1
	 */
public static void invokeForCaret(JEditTextArea textArea) {
    JEditBuffer buffer = textArea.getBuffer();
    int lineNum = textArea.getCaretLine();
    int start = buffer.getLineStartOffset(lineNum);
    int position = textArea.getCaretPosition();
    DefaultTokenHandler tokenHandler = new DefaultTokenHandler();
    buffer.markTokens(lineNum, tokenHandler);
    Token token = tokenHandler.getTokens();
    while (token.id != Token.END) {
        int next = start + token.length;
        if (start <= position && next > position)
            break;
        start = next;
        token = token.next;
    }
    if (token.id == Token.END || (token.id % Token.ID_COUNT) == Token.NULL) {
        JOptionPane.showMessageDialog(textArea.getView(), jEdit.getProperty("syntax-style-no-token.message"), jEdit.getProperty("syntax-style-no-token.title"), JOptionPane.PLAIN_MESSAGE);
        return;
    }
    String typeName = Token.tokenToString(token.id);
    String property = "view.style." + typeName.toLowerCase();
    Font font = new JLabel().getFont();
    SyntaxStyle currentStyle = SyntaxUtilities.parseStyle(jEdit.getProperty(property), font.getFamily(), font.getSize(), true);
    SyntaxStyle style = new StyleEditor(textArea.getView(), currentStyle, typeName).getStyle();
    if (style != null) {
        jEdit.setProperty(property, GUIUtilities.getStyleString(style));
        jEdit.propertiesChanged();
    }
}