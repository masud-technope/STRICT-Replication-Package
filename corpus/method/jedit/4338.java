//}}}
//{{{ back() method
HistoryEntry back(HelpViewer helpViewer) {
    if (historyPos <= 1) {
        return null;
    }
    setCurrentScrollPosition(helpViewer.getCurrentPage(), helpViewer.getCurrentScrollPosition());
    HistoryEntry result = new HistoryEntry(history[--historyPos - 1]);
    fireUpdate();
    return result;
}