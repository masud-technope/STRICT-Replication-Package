//}}}
//{{{ delete() method
private void delete(boolean forward) {
    if (!buffer.isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    if (getSelectionCount() != 0) {
        Selection[] selections = getSelection();
        for (Selection s : selections) {
            if (s instanceof Selection.Rect) {
                Selection.Rect r = (Selection.Rect) s;
                int startColumn = r.getStartColumn(buffer);
                if (startColumn == r.getEndColumn(buffer)) {
                    if (!forward && startColumn == 0)
                        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
                    else
                        tallCaretDelete(r, forward);
                } else
                    setSelectedText(s, null);
            } else
                setSelectedText(s, null);
        }
    } else if (forward) {
        if (caret == buffer.getLength()) {
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
            return;
        }
        deleteNextCharacter(caret);
    } else {
        if (caret == 0) {
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
            return;
        }
        deletePrevCodePoint(caret);
    }
}