//}}}
//{{{ insertEnterAndIndent() method
/**
	 * Inserts a line break and indents the new line. Moves the caret to
	 * the first non-whitespace character of the new line. If the newline
	 * character is an electric key the current line will also be
	 * re-indented.
	 */
public void insertEnterAndIndent() {
    if (!isEditable())
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
    else {
        String autoIndent = buffer.getStringProperty("autoIndent");
        if ("full".equals(autoIndent) && buffer.isElectricKey('\n', caretLine)) {
            buffer.indentLine(caretLine, true);
        }
        try {
            buffer.beginCompoundEdit();
            setSelectedText("\n");
            if ("full".equals(autoIndent)) {
                if (!buffer.indentLine(caretLine, true)) {
                    // caret needs to be moved explicitly.
                    if (lineContainsSpaceAndTabs(caretLine)) {
                        goToEndOfLine(false);
                    } else {
                        goToStartOfWhiteSpace(false);
                    }
                }
            } else if ("simple".equals(autoIndent))
                buffer.simpleIndentLine(caretLine);
        } finally {
            buffer.endCompoundEdit();
        }
    }
}