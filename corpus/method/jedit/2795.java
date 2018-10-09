//}}}
//{{{ addEntry() method
private static void addEntry(Entry entry) {
    historyLock.writeLock().lock();
    try {
        history.addFirst(entry);
        trimToLimit(history);
    } finally {
        historyLock.writeLock().unlock();
    }
}