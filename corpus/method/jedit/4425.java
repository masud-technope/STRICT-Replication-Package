//{{{ actionPerformed() method
public void actionPerformed(ActionEvent evt) {
    historyList = new JPopupMenu();
    HelpHistoryModel.HistoryEntry[] urls;
    if (type == BACK) {
        urls = history.getPreviousURLs();
    } else {
        urls = history.getNextURLs();
    }
    if (urls != null) {
        if (type == BACK) {
            for (int i = urls.length - 1; i >= 0; i--) {
                if (urls[i] != null) {
                    historyList.add(new HistoryListActionHandler(urls[i]));
                }
            }
        } else {
            for (HelpHistoryModel.HistoryEntry url : urls) {
                if (url != null)
                    historyList.add(new HistoryListActionHandler(url));
            }
        }
        historyList.show((JComponent) evt.getSource(), 0, 0);
    }
//}}}
}