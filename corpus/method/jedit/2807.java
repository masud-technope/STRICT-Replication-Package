//}}}
//{{{ getEntry() method
public static Entry getEntry(String path) {
    historyLock.readLock().lock();
    try {
        for (Entry entry : history) {
            if (MiscUtilities.pathsEqual(entry.path, path))
                return entry;
        }
    } finally {
        historyLock.readLock().unlock();
    }
    return null;
}