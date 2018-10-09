//{{{ HelpHistoryModel constructor
public  HelpHistoryModel(int size) {
    history = new HistoryEntry[size];
    listeners = new ArrayList<HelpHistoryModelListener>();
}