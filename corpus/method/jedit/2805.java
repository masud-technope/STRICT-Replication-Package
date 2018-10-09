//}}}
//{{{ clear() method
/**
	 * Clear the BufferHistory.
	 * @since 4.3pre6
	 */
public static void clear() {
    historyLock.writeLock().lock();
    try {
        history.clear();
    } finally {
        historyLock.writeLock().unlock();
    }
    notifyChange();
}