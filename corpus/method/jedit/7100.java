//}}}
//{{{ insertTabAndIndent() method
public void insertTabAndIndent() {
    if (!isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    boolean indent = "full".equals(buffer.getStringProperty("autoIndent"));
    if (indent && getSelectionCount() == 0) {
        // if caret is inside leading whitespace, indent.
        CharSequence text = buffer.getLineSegment(caretLine);
        int start = buffer.getLineStartOffset(caretLine);
        int whiteSpace = StandardUtilities.getLeadingWhiteSpace(text);
        if (caret - start <= whiteSpace && buffer.indentLine(caretLine, false))
            return;
    }
    userInput('\t');
}