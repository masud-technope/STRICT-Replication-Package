//}}}
//{{{ goToPrevBracket() method
/**
	 * Moves the caret to the previous bracket.
	 * @param select true if you want to extend selection
	 * @since jEdit 2.7pre2
	 */
public void goToPrevBracket(boolean select) {
    String text = getText(0, caret);
    int newCaret = -1;
    loop: for (int i = getCaretPosition() - 1; i >= 0; i--) {
        switch(text.charAt(i)) {
            case '(':
            case '[':
            case '{':
                newCaret = i;
                break loop;
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