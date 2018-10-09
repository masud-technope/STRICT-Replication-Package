//}}}
//{{{ removeEntry() method
private static void removeEntry(String path) {
    historyLock.writeLock().lock();
    try {
        Iterator<Entry> iter = history.iterator();
        while (iter.hasNext()) {
            Entry entry = iter.next();
            if (MiscUtilities.pathsEqual(path, entry.path)) {
                iter.remove();
                return;
            }
        }
    } finally {
        historyLock.writeLock().unlock();
    }
}