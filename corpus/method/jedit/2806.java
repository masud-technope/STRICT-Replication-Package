//}}}
//{{{ setEntry() method
public static void setEntry(String path, int caret, Selection[] selection, String encoding, String mode) {
    Entry entry = new Entry(path, caret, selectionToString(selection), encoding, mode);
    historyLock.writeLock().lock();
    try {
        removeEntry(path);
        addEntry(entry);
    } finally {
        historyLock.writeLock().unlock();
    }
    notifyChange();
}