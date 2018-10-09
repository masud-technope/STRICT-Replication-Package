public void emacsKillLine() {
    boolean lastActionWasThis = repeatingSameMacro("Emacs/Emacs_Kill_Line");
    int caret = textArea.getCaretPosition();
    int caretLine = textArea.getCaretLine();
    int lineEnd = textArea.getLineEndOffset(caretLine);
    // If we're at the end of line (ignoring any trailing white space),
    // then kill the newline, too.
    int caret2 = caret + 1;
    while (caret2 < lineEnd) {
        char ch = charAt(caret2);
        if (!Character.isWhitespace(ch))
            break;
        caret2++;
    }
    String deletedText = null;
    Selection selection = null;
    if (caret2 == lineEnd) {
        if (caretLine != textArea.getLastPhysicalLine())
            selection = new Selection.Range(caret, caret2);
    } else {
        // Simple delete to end of line.
        selection = new Selection.Range(caret, lineEnd - 1);
    //textArea.deleteToEndOfLine();
    }
    if (selection != null) {
        textArea.setSelection(selection);
        deletedText = textArea.getSelectedText();
        textArea.replaceSelection("");
        textArea.removeFromSelection(selection);
        if (lastActionWasThis) {
            String clipboard = getClipboard();
            if (clipboard == null)
                clipboard = "";
            setClipboard(clipboard + deletedText);
        } else {
            setClipboard(deletedText);
        }
    }
}