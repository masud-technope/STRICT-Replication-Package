//}}}
//{{{ addToHistory() method
public void addToHistory(String url) {
    history[historyPos] = new HistoryEntry(url, url, 0);
    if (historyPos + 1 == history.length) {
        System.arraycopy(history, 1, history, 0, history.length - 1);
        history[historyPos] = null;
    } else {
        historyPos++;
        for (int i = historyPos; i < history.length; i++) {
            history[i] = null;
        }
    }
    fireUpdate();
}