//{{{ removeUpdate() method
@Override
public void removeUpdate(DocumentEvent evt) {
    // on backspace, restart from beginning
    if (!hyperSearch.isSelected()) {
        String text = find.getText();
        if (text.length() != 0) {
            // invalid search string.
            if (regexp.isSelected()) {
                // reverse regexp search
                // not supported yet, so
                // 'simulate' with restart
                timerIncrementalSearch(0, false);
            } else {
                int start;
                JEditTextArea textArea = view.getTextArea();
                Selection s = textArea.getSelectionAtOffset(textArea.getCaretPosition());
                if (s == null)
                    start = textArea.getCaretPosition();
                else
                    start = s.getStart();
                timerIncrementalSearch(start, true);
            }
        }
    }
//}}}
}