//}}}
//{{{ getPreviousURLs() method
HistoryEntry[] getPreviousURLs() {
    if (historyPos <= 1) {
        return new HelpHistoryModel.HistoryEntry[0];
    }
    HistoryEntry[] previous = new HistoryEntry[historyPos - 1];
    System.arraycopy(history, 0, previous, 0, historyPos - 1);
    return previous;
}