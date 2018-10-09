//}}}
//{{{ historyNext() method
public void historyNext() {
    if (historyModel == null)
        return;
    if (index == -1)
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
    else if (index == 0)
        setText(current);
    else {
        // have to do this because setText() sets index to -1
        int newIndex = index - 1;
        setText(historyModel.getItem(newIndex));
        index = newIndex;
    }
}