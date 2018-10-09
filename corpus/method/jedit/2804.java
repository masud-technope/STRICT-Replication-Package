//}}}
//{{{ getHistory() method
/**
	 * Returns the Buffer list.
	 * @return the buffer history list
	 * @since jEdit 4.2pre2
	 */
@SuppressWarnings({ "unchecked" })
public static List<Entry> getHistory() {
    // Returns a snapshot to avoid concurrent access to the
    // history. This requires O(n) time, but it should be ok
    // because this method should be used only by external
    // O(n) operation.
    historyLock.readLock().lock();
    try {
        return (List<Entry>) history.clone();
    } finally {
        historyLock.readLock().unlock();
    }
}