//}}}
//{{{ doForwardSearch() method
public void doForwardSearch() {
    if (historyModel == null)
        return;
    if (text.getSelectionEnd() != getDocument().getLength()) {
        text.setCaretPosition(getDocument().getLength());
    }
    int start = getInputStart();
    String t = getText().substring(0, text.getSelectionStart() - start);
    if (t == null) {
        historyNext();
        return;
    }
    for (int i = index - 1; i >= 0; i--) {
        String item = historyModel.getItem(i);
        if (item.startsWith(t)) {
            text.replaceSelection(item.substring(t.length()));
            text.select(getInputStart() + t.length(), getDocument().getLength());
            index = i;
            return;
        }
    }
    javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
}