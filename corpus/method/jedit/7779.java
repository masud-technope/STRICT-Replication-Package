public Selection getKillRegion() {
    int caret = textArea.getCaretPosition();
    Selection selection = textArea.getSelectionAtOffset(caret);
    if (selection == null) {
        int mark = getMark(buffer);
        if (mark == -1) {
            beep();
            return null;
        }
        selection = new Selection.Range(Math.min(caret, mark), Math.max(caret, mark));
        textArea.setSelection(selection);
    }
    return selection;
}