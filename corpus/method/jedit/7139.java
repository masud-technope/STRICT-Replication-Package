//}}}
//{{{ goToNextBracket() method
/**
	 * Moves the caret to the next closing bracket.
	 * @param select true if you want to extend selection
	 * @since jEdit 2.7pre2.
	 */
public void goToNextBracket(boolean select) {
    int newCaret = -1;
    if (caret != buffer.getLength()) {
        String text = getText(caret, buffer.getLength() - caret - 1);
        loop: for (int i = 0; i < text.length(); i++) {
            switch(text.charAt(i)) {
                case ')':
                case ']':
                case '}':
                    newCaret = caret + i + 1;
                    break loop;
            }
        }
    }
    if (newCaret == -1)
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
    else {
        if (select)
            extendSelection(caret, newCaret);
        else if (!multi)
            selectNone();
        moveCaretPosition(newCaret);
    }
}