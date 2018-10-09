//{{{ actionPerformed() class
@Override
public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    String actionCommand = evt.getActionCommand();
    int separatorPosition = actionCommand.lastIndexOf(':');
    String url;
    int scrollPosition;
    if (-1 == separatorPosition) {
        url = actionCommand;
        scrollPosition = 0;
    } else {
        url = actionCommand.substring(0, separatorPosition);
        scrollPosition = Integer.parseInt(actionCommand.substring(separatorPosition + 1));
    }
    if (!url.isEmpty()) {
        gotoURL(url, false, scrollPosition);
        return;
    }
    if (source == back) {
        HistoryEntry entry = historyModel.back(HelpViewer.this);
        if (entry == null) {
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        } else {
            gotoURL(entry.url, false, entry.scrollPosition);
        }
    } else if (source == forward) {
        HistoryEntry entry = historyModel.forward(HelpViewer.this);
        if (entry == null) {
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        } else {
            gotoURL(entry.url, false, entry.scrollPosition);
        }
    }
//}}}
}