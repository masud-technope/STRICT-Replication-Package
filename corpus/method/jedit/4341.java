//}}}
//{{{ setCurrentEntry() method
public void setCurrentEntry(HistoryEntry entry) {
    for (int i = 0; i < history.length; i++) {
        if ((history[i] != null) && (history[i].equals(entry))) {
            historyPos = i + 1;
            fireUpdate();
            break;
        }
    }
// Do nothing?
}