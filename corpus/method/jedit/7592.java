//{{{ fireIntervalAdded() method
private void fireIntervalAdded(int index1, int index2) {
    for (ListDataListener listener : listeners) {
        listener.intervalAdded(new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, index1, index2));
    }
//}}}
}