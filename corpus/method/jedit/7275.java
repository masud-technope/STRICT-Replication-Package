//}}}
//{{{ setSelectedText() methods
/**
	 * Replaces the selection with the specified text.
	 * @param s The selection
	 * @param selectedText The new text
	 * @since jEdit 3.2pre1
	 */
public void setSelectedText(Selection s, String selectedText) {
    if (!isEditable()) {
        throw new InternalError("Text component" + " read only");
    }
    try {
        buffer.beginCompoundEdit();
        moveCaretPosition(s.setText(buffer, selectedText));
    } finally // No matter what happends... stops us from leaving buffer
    // in a bad state
    {
        buffer.endCompoundEdit();
    }
// no no no!!!!
//selectNone();
}