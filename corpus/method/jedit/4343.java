//}}}
//{{{ forward() method
HistoryEntry forward(HelpViewer helpViewer) {
    if (history.length - historyPos <= 1) {
        return null;
    }
    if (history[historyPos] == null) {
        return null;
    }
    setCurrentScrollPosition(helpViewer.getCurrentPage(), helpViewer.getCurrentScrollPosition());
    HistoryEntry result = new HistoryEntry(history[historyPos]);
    historyPos++;
    fireUpdate();
    return result;
}