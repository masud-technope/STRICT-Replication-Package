//{{{ fireIntervalRemoved() method
private void fireIntervalRemoved(int index1, int index2) {
    for (ListDataListener listener : listeners) {
        listener.intervalRemoved(new ListDataEvent(this, ListDataEvent.INTERVAL_REMOVED, index1, index2));
    }
//}}}
}