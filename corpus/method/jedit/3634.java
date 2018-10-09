//}}}
//{{{ historyPrevious() method
public void historyPrevious() {
    if (historyModel == null)
        return;
    if (index == historyModel.getSize() - 1)
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
    else if (index == -1) {
        current = getText();
        setText(historyModel.getItem(0));
        index = 0;
    } else {
        // have to do this because setText() sets index to -1
        int newIndex = index + 1;
        setText(historyModel.getItem(newIndex));
        index = newIndex;
    }
}