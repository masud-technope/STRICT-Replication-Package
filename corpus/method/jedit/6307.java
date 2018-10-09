//{{{ insertUpdate() method
@Override
public void insertUpdate(DocumentEvent evt) {
    // the current match until another match is found
    if (!hyperSearch.isSelected()) {
        int start;
        JEditTextArea textArea = view.getTextArea();
        Selection s = textArea.getSelectionAtOffset(textArea.getCaretPosition());
        if (s == null)
            start = textArea.getCaretPosition();
        else
            start = s.getStart();
        timerIncrementalSearch(start, false);
    }
//}}}
}