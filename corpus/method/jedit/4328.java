//}}}
//{{{ fireUpdate() method
public void fireUpdate() {
    for (HelpHistoryModelListener listener : listeners) listener.historyUpdated();
}