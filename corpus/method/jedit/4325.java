//}}}
//{{{ getNextURLs() method
HistoryEntry[] getNextURLs() {
    if (history.length - historyPos <= 1) {
        return new HelpHistoryModel.HistoryEntry[0];
    }
    if (history[historyPos] == null) {
        return new HelpHistoryModel.HistoryEntry[0];
    }
    HistoryEntry[] next = new HistoryEntry[history.length - historyPos];
    System.arraycopy(history, historyPos, next, 0, history.length - historyPos);
    return next;
}